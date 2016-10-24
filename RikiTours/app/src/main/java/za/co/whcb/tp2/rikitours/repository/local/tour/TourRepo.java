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
import za.co.whcb.tp2.rikitours.config.database.table.customer.CustomerTable;
import za.co.whcb.tp2.rikitours.config.database.table.tour.CountryTable;
import za.co.whcb.tp2.rikitours.config.database.table.tour.ItenaryTable;
import za.co.whcb.tp2.rikitours.config.database.table.tour.TourTable;
import za.co.whcb.tp2.rikitours.config.database.table.tourguide.TourGuideTable;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.domain.tour.Itenary;
import za.co.whcb.tp2.rikitours.domain.tour.Tour;
import za.co.whcb.tp2.rikitours.domain.tourguide.Guide;
import za.co.whcb.tp2.rikitours.factories.customer.CustomerFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.factories.tour.TourFactory;
import za.co.whcb.tp2.rikitours.factories.tourGuide.TourGuideFactory;

/**
 * Created by Encore on 10/17/2016.
 */
public class TourRepo extends SQLiteOpenHelper {
    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static TourTable tourTable;
    private static TourGuideTable guideTable;
    private static CountryTable countryTable;
    private static ItenaryTable itenaryTable;
    private static CustomerTable customerTable;

    public TourRepo(Context context)
    {
        super(context, Database.name, null, Database.version);
        tourTable = new TourTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(tourTable.getTableName(),tourTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + tourTable.getTableName());
        onCreate(db);
    }

    public boolean addTour(Tour tour ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        tourTable  = new TourTable();
        contentValues = new ContentValues();

        contentValues.put(tourTable.getAttributeId().name, tour.getId());
        contentValues.put(tourTable.getAttributeCustomerId().name, tour.getCustomer().getId());
        contentValues.put(tourTable.getAttributeGuideId().name, tour.getGuide().getId());
        contentValues.put(tourTable.getAttributeItenryId().name, tour.getItenary().getId());
        try {
            returned = localDatabase.insert(tourTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public ArrayList<Tour> getAllTours() {
        ArrayList<Tour> tour = new ArrayList<>();

        Tour tourFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(tourTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                tourFound = TourFactory.getTour(data.getLong(0), findGuideById(data.getLong(1)),findCustomerById(data.getLong(2)),findItenaryById(data.getLong(4)));
                tour.add(tourFound);
            }
        }
        return tour;
    }

    public boolean updateTour(Tour updatedTour, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(tourTable.getAttributeCustomerId().name,updatedTour.getCustomer().getId());
        contentValues.put(tourTable.getAttributeGuideId().name,updatedTour.getGuide().getId());
        contentValues.put(tourTable.getAttributeItenryId().name,updatedTour.getItenary().getId());

        try {

            returned =  localDatabase.update(tourTable.getTableName(),
                    contentValues, tourTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(tourTable.getTableName(),
                    tourTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }

    public Tour findTourById(long id) {
        Tour tourFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(tourTable.getTableName(),
                tourTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                tourFound = TourFactory.getTour(data.getLong(0), findGuideById(data.getLong(1)),findCustomerById(data.getLong(2)),findItenaryById(data.getLong(4)));
            }
        }
        return tourFound;
    }

    private Itenary findItenaryById(long id) {
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

    private Guide findGuideById(long id){
        Guide tourguideFound=null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(guideTable.getTableName(),
                guideTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);
        if(data.getCount()!=0){
            while(data.moveToNext()){
                tourguideFound= TourGuideFactory.getGuide(data.getLong(0),data.getString(1),data.getString(2),data.getString(3),data.getString(4));
            }
        }
        return tourguideFound;

    }
    private Country findCountryById(long id) {
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
    private Customer findCustomerById(long id) {
        Customer customerFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(customerTable.getTableName(),
                customerTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if (data.getCount() != 0) {
            while (data.moveToNext()) {
                customerFound = CustomerFactory.getCustomer(data.getLong(0),data.getString(1), data.getString(1),
                        data.getString(2));
            }
        }
        return customerFound;
    }

}
