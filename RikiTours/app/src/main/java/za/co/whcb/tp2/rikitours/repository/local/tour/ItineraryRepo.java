package za.co.whcb.tp2.rikitours.repository.local.tour;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.tour.ItineraryTable;
import za.co.whcb.tp2.rikitours.domain.tour.Itinerary;

/**
 * Created by work on 10/17/2016.
 */
public class ItineraryRepo extends SQLiteOpenHelper {
    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static ItineraryTable itineraryTable;


    public ItineraryRepo(Context context) {
        super(context, Database.name, null, Database.version);
        itineraryTable = new ItineraryTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(itineraryTable.getTableName(), itineraryTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + itineraryTable.getTableName());
        onCreate(db);
    }

    public boolean addItenary(Itinerary itinerary) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        itineraryTable = new ItineraryTable();
        contentValues = new ContentValues();

        contentValues.put(itineraryTable.getAttributeId().name, itinerary.getId());
        contentValues.put(itineraryTable.getAttributeGroupAttractionId().name, itinerary.getAttractions().toString());

        try {
            returned = localDatabase.insert(itineraryTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public Itinerary findCountryById(long id) {
        Itinerary itineraryFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(itineraryTable.getTableName(),
                itineraryTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
               /* attractionFound = AttractionFactory.getAttraction(data.getLong(0), data.getLong(1), data.getLong(2));*/
            }
        }
        return itineraryFound;
    }
}
