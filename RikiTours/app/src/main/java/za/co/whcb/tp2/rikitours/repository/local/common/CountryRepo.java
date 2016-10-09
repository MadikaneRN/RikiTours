package za.co.whcb.tp2.rikitours.repository.local.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.common.Display;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.common.CountryTable;
import za.co.whcb.tp2.rikitours.domain.tour.Country;

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


        contentValues.put(countryTable.getAttrubeId().name, country.getId());
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

    public String test() {
        return "works";
    }
}
