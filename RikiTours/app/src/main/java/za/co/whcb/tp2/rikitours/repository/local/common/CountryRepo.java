package za.co.whcb.tp2.rikitours.repository.local.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.common.CountryTable;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;

/**
 * Created by work on 10/8/2016.
 */
public class CountryRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static CountryTable countryTable ;


    public CountryRepo(Context context) {
        super(context, Database.name, null, Database.version);
        countryTable = new CountryTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(countryTable.getTableName(),countryTable.getAllAttributes());
            db.execSQL(query);
        }
       catch (Exception ex) {
           Log.d("SQL ERROR", ex.getMessage());

       }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + countryTable.getTableName());
        onCreate(db);
    }

    public boolean addCountry(Country country ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        countryTable  = new CountryTable();
        contentValues = new ContentValues();

        contentValues.put(countryTable.getAttributeId().name, country.getId());
        contentValues.put(countryTable.getAttributeName().name, country.getName());
        contentValues.put(countryTable.getAttributeImage().name, "");
        contentValues.put(countryTable.getAttributeDescription().name, country.getDescription());

        try {
            returned = localDatabase.insert(countryTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public Country findCountryById(long id) {
        Country countryFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(countryTable.getTableName(),
                        countryTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                countryFound = CountryFactory.getCountry(data.getLong(0), data.getString(1),
                                data.getString(2), data.getString(3));
            }
        }
        return countryFound;
    }

    public ArrayList<Country> getAllCountries() {
        ArrayList<Country> countries = new ArrayList<>();
        Country countryFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(countryTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                countryFound = CountryFactory.getCountry(data.getLong(0), data.getString(1),
                        data.getString(2), data.getString(3));
                countries.add(countryFound);
            }
        }

        return countries;
    }

    public boolean updateCountry(Country updatedCountry, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(countryTable.getAttributeName().name,updatedCountry.getName());
        contentValues.put(countryTable.getAttributeDescription().name,updatedCountry.getDescription());
        contentValues.put(countryTable.getAttributeImage().name,updatedCountry.getImage());

        try {

            returned =  localDatabase.update(countryTable.getTableName(),
                    contentValues,countryTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;
    }

    public boolean deleteById(long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();

        try {

            returned =  localDatabase.delete(countryTable.getTableName(),
                    countryTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}
