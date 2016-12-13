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
import za.co.whcb.tp2.rikitours.config.database.table.tour.AttractionDescriptionTable;
import za.co.whcb.tp2.rikitours.config.database.table.tour.AttractionTable;
import za.co.whcb.tp2.rikitours.config.database.table.tour.CountryTable;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;

/**
 * Created by work on 10/10/2016.
 */
public class AttractionsRepo extends SQLiteOpenHelper {
    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static AttractionTable attractionTable ;
    private static CountryTable countryTable;
    private static AttractionDescriptionTable attractionDescriptionTable;


    public AttractionsRepo(Context context) {
        super(context, Database.name, null, Database.version);
        attractionTable = new AttractionTable();
        countryTable = new CountryTable();
        attractionDescriptionTable = new AttractionDescriptionTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(attractionTable.getTableName(),attractionTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + attractionTable.getTableName());
        onCreate(db);
    }

    public boolean addAttraction(Attraction attraction ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        attractionTable  = new AttractionTable();
        contentValues = new ContentValues();

        contentValues.put(attractionTable.getAttributeId().name, attraction.getId());
        contentValues.put(attractionTable.getCountryId().name, attraction.getCountry().getId());
        contentValues.put(attractionTable.getAttractionDescriptionId().name, attraction.getAttractionDescription().getId());
        contentValues.put(attractionTable.getStatus().name, attraction.getStatus());

        try {
            returned = localDatabase.insert(attractionTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());
        }

        return (returned != -1) ? true : false;
    }

    public Attraction findAtractionById(long id) {
        Attraction attractionFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(attractionTable.getTableName(),
                attractionTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                attractionFound = AttractionFactory.getAttraction(data.getLong(0), findAttractionCountryById(data.getLong(1)), findAttractionDescriptionById(data.getLong(2)));
            }
        }
        return attractionFound;
    }

    private Country findAttractionCountryById(long id) {
        Country countryFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(countryTable.getTableName(),
                countryTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {

                countryFound = CountryFactory.getCountry(data.getLong(0), data.getString(1), data.getString(2), data.getString(3));
            }
        }
        return countryFound;
    }

    private AttractionDescription findAttractionDescriptionById(long id) {
        AttractionDescription attractionDescriptionFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(attractionDescriptionTable.getTableName(),
                attractionDescriptionTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {

                attractionDescriptionFound = AttractionDescriptionFactory.getAttractionDescription(data.getLong(0), data.getString(1), data.getString(2), data.getString(3),data.getString(4));
            }
        }
        return attractionDescriptionFound;
    }

    public ArrayList<Attraction> getAllAttractions() {
        ArrayList<Attraction> descriptions = new ArrayList<>();
        Attraction attractionFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(attractionTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                attractionFound = AttractionFactory.getAttraction(data.getLong(0), findAttractionCountryById(data.getLong(1)), findAttractionDescriptionById(data.getLong(2)));
                descriptions.add(attractionFound);
            }
        }

        return descriptions;
    }

    public boolean updateAttraction(Attraction updatedAttraction, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(attractionTable.getCountryId().name,updatedAttraction.getCountry().getId());
        contentValues.put(attractionTable.getAttractionDescriptionId().name,updatedAttraction.getAttractionDescription().getId());
        try {

            returned =  localDatabase.update(attractionTable.getTableName(),
                    contentValues, attractionTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(attractionTable.getTableName(),
                    attractionTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }

    public ArrayList<Attraction> getInterestedAttarctions(String tag){
        Attraction attractionFound = null;
        ArrayList<Attraction> attractionsList =  new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(attractionTable.getTableName(),
                attractionTable.getAttributeId(), tag);
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                attractionFound = AttractionFactory.getAttraction(data.getLong(0), findAttractionCountryById(data.getLong(1)), findAttractionDescriptionById(data.getLong(2)));
                attractionsList.add(attractionFound);
            }
        }
        return attractionsList;
    }
}
