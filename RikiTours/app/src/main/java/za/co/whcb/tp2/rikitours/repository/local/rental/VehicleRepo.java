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
import za.co.whcb.tp2.rikitours.config.database.table.rental.VehicleTable;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;
import za.co.whcb.tp2.rikitours.factories.rental.VehicleFactory;

/**
 * Created by berka on 10/10/2016.
 */
public class VehicleRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static VehicleTable vehicleTable;



    public VehicleRepo(Context context) {
        super(context, Database.name, null, Database.version);
        vehicleTable = new VehicleTable();
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(vehicleTable.getTableName(),vehicleTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }


    public boolean addVehicle(Vehicle vehicle ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        vehicleTable  = new VehicleTable();
        contentValues = new ContentValues();

        contentValues.put(vehicleTable.getAttributeId().name, vehicle.getId());
        contentValues.put(vehicleTable.getAttributevehicleName().name,vehicle.getVehicleName());
        contentValues.put(vehicleTable.getAttributevehicleModel().name, vehicle.getVehicleModel());
        contentValues.put(vehicleTable.getAttributevehicleYear().name, vehicle.getVehicleYear());


        try {
            returned = localDatabase.insert(vehicleTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + vehicleTable.getTableName());
        onCreate(db);
    }


    public Vehicle findVehicleById(long id) {
        Vehicle vehicleFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(vehicleTable.getTableName(),
                vehicleTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                vehicleFound = VehicleFactory.getVehicle(data.getLong(0), data.getString(1),
                        data.getString(2), data.getString(3));
            }
        }
        return vehicleFound;
    }


    public ArrayList<Vehicle> getAllVehicles() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicleFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(vehicleTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                vehicleFound = VehicleFactory.getVehicle(data.getLong(0), data.getString(1),
                        data.getString(2), data.getString(3));
                vehicles.add(vehicleFound);
            }
        }

        return vehicles;
    }


    public boolean updateVehicle(Vehicle updatedVehicle, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(vehicleTable.getAttributevehicleName().name,updatedVehicle.getVehicleName());
        contentValues.put(vehicleTable.getAttributevehicleModel().name,updatedVehicle.getVehicleModel());
        contentValues.put(vehicleTable.getAttributevehicleYear().name,updatedVehicle.getVehicleYear());

        try {

            returned =  localDatabase.update(vehicleTable.getTableName(),
                    contentValues,vehicleTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(vehicleTable.getTableName(),
                    vehicleTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }

//Add Delete, Get All, Update




}
