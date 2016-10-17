package za.co.whcb.tp2.rikitours.repository.local.tour;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.tour.CityDescriptionTable;
import za.co.whcb.tp2.rikitours.config.database.table.tour.CityTable;
import za.co.whcb.tp2.rikitours.config.database.table.tour.EventDescriptionTable;
import za.co.whcb.tp2.rikitours.config.database.table.tour.EventsTable;
import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.domain.tour.Events;
import za.co.whcb.tp2.rikitours.domain.tour.EventsDescription;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.factories.tour.EventDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.EventFactory;

/**
 * Created by Shaun Mesias on 2016/10/17.
 */
public class EventsRepo extends SQLiteOpenHelper{
    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static EventsTable eventsTable ;
    private static EventDescriptionTable eventDescriptionTable;
    private static CityTable cityTable;
    private static CityDescriptionTable descriptionTable;


    public EventsRepo(Context context) {

        super(context, Database.name, null, Database.version);
        eventsTable = new EventsTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(eventsTable.getTableName(), eventsTable.getAllAttributes());
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

    public boolean addEvent(Events events ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        eventsTable  = new EventsTable();
        contentValues = new ContentValues();

        contentValues.put(eventsTable.getAttributeId().name, events.getId());
        contentValues.put(eventsTable.getAttributeName().name, events.getName());
        contentValues.put(eventsTable.getDescriptionId().name, events.getDescription().getId());

        try {
            returned = localDatabase.insert(eventsTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public Events findEventById(long id) {
        Events eventFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(eventsTable.getTableName(),
                eventsTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);



        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                eventFound = EventFactory.getEvents(data.getLong(0), data.getString(1), findEventDecsriptionById(data.getLong(2)));
            }
        }
        return eventFound;
    }

    private EventsDescription findEventDecsriptionById(long id) {
        EventsDescription descriptionFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(eventDescriptionTable.getTableName(),
                eventDescriptionTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {

                descriptionFound = EventDescriptionFactory.getEventDescription(data.getLong(0), data.getString(1), data.getString(2), data.getString(3), findCountryById(data.getLong(4)));
            }
        }
        return descriptionFound;
    }

    private Country findCountryById(long id) {
        Country countryFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(cityTable.getTableName(),
                cityTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                countryFound = CountryFactory.getCountry(data.getLong(0), data.getString(1), data.getString(2), data.getString(3));
            }
        }
        return countryFound;
    }

    private CityDescription findCityDescriptionById(long id) {
        CityDescription descriptionFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(descriptionTable.getTableName(),
                descriptionTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {

                descriptionFound = CityDescriptionFactory.getCityDescription(data.getLong(0), data.getString(1), data.getString(2));
            }
        }
        return descriptionFound;
    }

}
