package za.co.whcb.tp2.rikitours.repository.local.tour;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.tour.EventsTable;
import za.co.whcb.tp2.rikitours.domain.tour.Events;

/**
 * Created by work on 10/17/2016.
 */
public class EventsRepo extends SQLiteOpenHelper {
    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static EventsTable eventsTable;


    public EventsRepo(Context context) {
        super(context, Database.name, null, Database.version);
        eventsTable = new EventsTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(eventsTable.getTableName(),eventsTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + eventsTable.getTableName());
        onCreate(db);
    }

    public boolean addCountry(Events events ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        eventsTable  = new EventsTable();
        contentValues = new ContentValues();

        contentValues.put(eventsTable.getAttributeId().name, events.getId());
        contentValues.put(eventsTable.getDescriptionId().name, events.getDescription().getId());
        contentValues.put(eventsTable.getAttributeName().name, events.getName());

        try {
            returned = localDatabase.insert(eventsTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public Events findCountryById(long id) {
        Events eventsFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(eventsTable.getTableName(),
                eventsTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
               /* attractionFound = AttractionFactory.getAttracion(data.getLong(0), data.getLong(1), data.getLong(2));*/
            }
        }
        return eventsFound;
    }
}
