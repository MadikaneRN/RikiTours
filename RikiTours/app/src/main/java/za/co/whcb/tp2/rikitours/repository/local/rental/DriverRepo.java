package za.co.whcb.tp2.rikitours.repository.local.rental;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.rental.DriverTable;
import za.co.whcb.tp2.rikitours.domain.rental.Driver;
import za.co.whcb.tp2.rikitours.factories.rental.DriverFactory;

/**
 * Created by berka on 10/16/2016.
 */
public class DriverRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static DriverTable driverTable;


    public DriverRepo(Context context) {
        super(context, Database.name, null, Database.version);
        driverTable = new DriverTable();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(driverTable.getTableName(),driverTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + driverTable.getTableName());
        onCreate(db);
    }


        public boolean addDriver(Driver driver ) {
            long returned ;
            localDatabase = this.getWritableDatabase();
            driverTable  = new DriverTable();
            contentValues = new ContentValues();

            contentValues.put(driverTable.getAttributeId().name, driver.getId());
            contentValues.put(driverTable.getAttributeFname().name,driver.getFname());
            contentValues.put(driverTable.getAttributeActive().name,driver.getActive());
            contentValues.put(driverTable.getAttributeDriverId().name,driver.getId());

            try {
                returned = localDatabase.insert(driverTable.getTableName(), null, contentValues);
            }catch (Exception ex) {
                returned = 0;
                Log.d("exception ::::",ex.getMessage());

            }

            return (returned != -1) ? true : false;
        }




    public Driver findDriverById(long id) {
        Driver vehicleFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(driverTable.getTableName(),
                driverTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                vehicleFound = DriverFactory.getDriver(data.getLong(0), data.getString(1),
                        data.getString(2), data.getString(3));
            }
        }
        return vehicleFound;
    }



    public ArrayList<Driver> getAllDrivers() {
        ArrayList<Driver> drivers = new ArrayList<>();
        Driver driverFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(driverTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                driverFound = DriverFactory.getDriver(data.getLong(0), data.getString(1),
                        data.getString(2), data.getString(3));
                drivers.add(driverFound);
            }
        }

        return drivers;
    }



    public boolean updateDriver(Driver updatedDriver, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();


        contentValues.put(driverTable.getAttributeFname().name,updatedDriver.getFname());
        contentValues.put(driverTable.getAttributeActive().name,updatedDriver.getActive());
        contentValues.put(driverTable.getAttributeDriverId().name,updatedDriver.getId());

        try {

            returned =  localDatabase.update(driverTable.getTableName(),
                    contentValues,driverTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(driverTable.getTableName(),
                    driverTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }
        return (returned != 0) ? true : false;

    }




}






