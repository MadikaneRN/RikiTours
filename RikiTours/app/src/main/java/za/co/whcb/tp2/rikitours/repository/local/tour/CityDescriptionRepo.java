package za.co.whcb.tp2.rikitours.repository.local.tour;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.tour.CityDescriptionTable;
import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;

/**
 * Created by Shaun Mesias on 2016/10/17.
 */
public class CityDescriptionRepo extends SQLiteOpenHelper {
    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static CityDescriptionTable descriptionTable ;


    public CityDescriptionRepo(Context context) {
        super(context, Database.name, null, Database.version);
        descriptionTable = new CityDescriptionTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(descriptionTable.getTableName(), descriptionTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + descriptionTable.getTableName());
        onCreate(db);
    }

    public boolean addCityDescription(CityDescription description ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        descriptionTable  = new CityDescriptionTable();
        contentValues = new ContentValues();

        contentValues.put(descriptionTable.getAttributeId().name, description.getId());
        contentValues.put(descriptionTable.getSuburbId().name, description.getSuburb());
        contentValues.put(descriptionTable.getNationId().name, description.getNation());

        try {
            returned = localDatabase.insert(descriptionTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public CityDescription findCityDescriptionById(long id) {
        CityDescription attractionFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(descriptionTable.getTableName(),
                descriptionTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                attractionFound = CityDescriptionFactory.getCityDescription(data.getLong(0), data.getString(1), data.getString(2));
            }
        }
        return attractionFound;
    }

    public ArrayList<CityDescription> getAllCityDescriptions() {
        ArrayList<CityDescription> descriptions = new ArrayList<>();
        CityDescription descriptionFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(descriptionTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                descriptionFound = CityDescriptionFactory.getCityDescription(data.getLong(0), data.getString(1), data.getString(2));
                descriptions.add(descriptionFound);
            }
        }

        return descriptions;
    }

    public boolean updateCityDescription(CityDescription updatedCityDescription, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(descriptionTable.getSuburbId().name,updatedCityDescription.getSuburb());
        contentValues.put(descriptionTable.getNationId().name,updatedCityDescription.getNation());

        try {

            returned =  localDatabase.update(descriptionTable.getTableName(),
                    contentValues, descriptionTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(descriptionTable.getTableName(),
                    descriptionTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}
