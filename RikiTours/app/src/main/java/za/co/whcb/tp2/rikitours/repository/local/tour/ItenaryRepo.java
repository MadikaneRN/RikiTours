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
import za.co.whcb.tp2.rikitours.config.database.table.tour.ItenaryTable;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.domain.tour.EventsDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Itenary;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.factories.tour.EventDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.ItenaryFactory;

/**
 * Created by Encore on 10/17/2016.
 */
public class ItenaryRepo extends SQLiteOpenHelper {
    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static ItenaryTable itenaryTable;
    private static AttractionTable attractionTable;
    private static CountryTable countryTable;
    private static AttractionDescriptionTable attractionDescriptionTable;

    public ItenaryRepo(Context context) {
        super(context, Database.name, null, Database.version);
        itenaryTable = new ItenaryTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(itenaryTable.getTableName(),itenaryTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + itenaryTable.getTableName());
        onCreate(db);
    }

    public boolean addItenary(Itenary itenary ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        itenaryTable  = new ItenaryTable();
        contentValues = new ContentValues();

        contentValues.put(itenaryTable.getAttributeId().name, itenary.getId());
        contentValues.put(itenaryTable.getAttributeGroupAttractionId().name, itenary.getAttractions().toString());

        try {
            returned = localDatabase.insert(itenaryTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public ArrayList<Itenary> getAllItenaries() {
        ArrayList<Itenary> itenaries = new ArrayList<>();

        EventsDescription itenariesFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(itenaryTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
            //itenaryFound = ItenaryFactory.getItenary(data.getLong(0),findAttractionById(data.getLong(1)));
                //itenaries.add(itenariesFound);
            }
        }
        return itenaries;
    }

    public boolean updateItenary(Itenary updatedItenary, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(itenaryTable.getAttributeGroupAttractionId().name,updatedItenary.getAttractions().toString());

        try {

            returned =  localDatabase.update(itenaryTable.getTableName(),
                    contentValues, itenaryTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(itenaryTable.getTableName(),
                    itenaryTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }


    public Itenary findItenaryById(long id) {
        Itenary itenaryFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(itenaryTable.getTableName(),
                itenaryTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                /*itenaryFound = ItenaryFactory.getItenary(data.getLong(0),findAttractionById(data.getLong(1)));*/
            }
        }
        return itenaryFound;
    }
    private Attraction findAttractionById(long id){
        Attraction attractionFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(attractionTable.getTableName(),
                attractionTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                attractionFound = AttractionFactory.getAttracion(data.getLong(0), findAttractionCountryById(data.getLong(1)), findAttractionDescriptionById(data.getLong(2)));
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

                attractionDescriptionFound = AttractionDescriptionFactory.getAttracionDescription(data.getLong(0), data.getString(1), data.getString(2), data.getString(3),data.getString(4));
            }
        }
        return attractionDescriptionFound;
    }
}
