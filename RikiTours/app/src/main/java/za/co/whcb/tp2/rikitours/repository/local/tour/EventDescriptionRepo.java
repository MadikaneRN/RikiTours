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
import za.co.whcb.tp2.rikitours.config.database.table.tour.CountryTable;
import za.co.whcb.tp2.rikitours.config.database.table.tour.EventDescriptionTable;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.domain.tour.EventsDescription;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.factories.tour.EventDescriptionFactory;

/**
 * Created by work on 10/17/2016.
 */
public class EventDescriptionRepo extends SQLiteOpenHelper {
    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static EventDescriptionTable eventDescriptionTable;
    private static CountryTable countryTable;


    public EventDescriptionRepo(Context context) {
        super(context, Database.name, null, Database.version);
        eventDescriptionTable = new EventDescriptionTable();
        countryTable = new CountryTable();
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

    public boolean addEvent(EventsDescription eventsDescription ) {
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

    public EventsDescription findEventsDescriptionById(long id) {
        EventsDescription eventsDescriptionFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(eventDescriptionTable.getTableName(),
                eventDescriptionTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                eventsDescriptionFound = EventDescriptionFactory.getEventDescription(data.getLong(0), data.getString(1), data.getString(2), data.getString(3), findCountryById(data.getLong(4)));
            }
        }
        return eventsDescriptionFound;
    }

    public Country findCountryById(long id) {
        Country countryFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(countryTable.getTableName(),
                countryTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                countryFound = CountryFactory.getCountry(data.getLong(0), data.getString(1), data.getString(2) , data.getString(3));
            }
        }
        return countryFound;
    }

    public ArrayList<EventsDescription> getAllEventsDescription() {
        ArrayList<EventsDescription> descriptions = new ArrayList<>();
        EventsDescription eventsDescriptionFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(eventDescriptionTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                eventsDescriptionFound = EventDescriptionFactory.getEventDescription(data.getLong(0), data.getString(1), data.getString(2), data.getString(3), findCountryById(data.getLong(4)));
                descriptions.add(eventsDescriptionFound);
            }
        }

        return descriptions;
    }

    public boolean updateEventDescription(EventsDescription updatedEventsDescription, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(eventDescriptionTable.getAttributeDescription().name,updatedEventsDescription.getDescription());
        contentValues.put(eventDescriptionTable.getAttributeStart().name,updatedEventsDescription.getStart());
        contentValues.put(eventDescriptionTable.getAttributeEnd().name,updatedEventsDescription.getEnd());
        contentValues.put(eventDescriptionTable.getAttributeCountryId().name,updatedEventsDescription.getCountry().getId());

        try {

            returned =  localDatabase.update(eventDescriptionTable.getTableName(),
                    contentValues, eventDescriptionTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(eventDescriptionTable.getTableName(),
                    eventDescriptionTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}
