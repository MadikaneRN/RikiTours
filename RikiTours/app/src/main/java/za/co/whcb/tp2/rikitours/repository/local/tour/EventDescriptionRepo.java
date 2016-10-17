package za.co.whcb.tp2.rikitours.repository.local.tour;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.tour.EventDescriptionTable;
import za.co.whcb.tp2.rikitours.domain.tour.EventsDescription;

/**
 * Created by work on 10/17/2016.
 */
public class EventDescriptionRepo extends SQLiteOpenHelper {
    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static EventDescriptionTable eventDescriptionTable;


    public EventDescriptionRepo(Context context) {
        super(context, Database.name, null, Database.version);
        eventDescriptionTable = new EventDescriptionTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(eventDescriptionTable.getTableName(),eventDescriptionTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + eventDescriptionTable.getTableName());
        onCreate(db);
    }

    public boolean addCountry(EventsDescription eventsDescription ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        eventDescriptionTable  = new EventDescriptionTable();
        contentValues = new ContentValues();

        contentValues.put(eventDescriptionTable.getAttributeId().name, eventsDescription.getId());
        contentValues.put(eventDescriptionTable.getAttributeCountryId().name, eventsDescription.getCountry().getId());
        contentValues.put(eventDescriptionTable.getAttributeDescription().name, eventsDescription.getDescription());
        contentValues.put(eventDescriptionTable.getAttributeStart().name, eventsDescription.getStart());
        contentValues.put(eventDescriptionTable.getAttributeEnd().name, eventsDescription.getEnd());

        try {
            returned = localDatabase.insert(eventDescriptionTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public EventsDescription findCountryById(long id) {
        EventsDescription eventsDescriptionFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(eventDescriptionTable.getTableName(),
                eventDescriptionTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
               /* attractionFound = AttractionFactory.getAttracion(data.getLong(0), data.getLong(1), data.getLong(2));*/
            }
        }
        return eventsDescriptionFound;
    }
}
