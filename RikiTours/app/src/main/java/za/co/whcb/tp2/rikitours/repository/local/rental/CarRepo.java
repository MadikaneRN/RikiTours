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
import za.co.whcb.tp2.rikitours.config.database.table.car.CarTable;
import za.co.whcb.tp2.rikitours.config.database.table.rental.VehicleTable;
import za.co.whcb.tp2.rikitours.domain.rental.Car;
import za.co.whcb.tp2.rikitours.factories.rental.CarFactory;

/**
 * Created by berka on 12/12/2016.
 */
public class CarRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static CarTable carTable;

    public CarRepo(Context context)
    {
        super(context, Database.name, null, Database.version);
        carTable = new CarTable();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            final String query = Converter.toCreateTableQuery(carTable.getTableName(),carTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + carTable.getTableName());
        onCreate(db);
    }
    public boolean deleteById(long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();

        try {

            returned =  localDatabase.delete(carTable.getTableName(),
                    carTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
    public boolean updateCar(Car updatedVehicle, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(carTable.getRegNumber().name,updatedVehicle.getRegistrationNumber());
        contentValues.put(carTable.getCarType().name,updatedVehicle.getCarType());

        try {

            returned =  localDatabase.update(carTable.getTableName(),
                    contentValues,carTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;
    }
    public ArrayList<Car> getAllVehicles() {
        ArrayList<Car> vehicles = new ArrayList<>();
        Car vehicleFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(carTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                vehicleFound = CarFactory.getCar(data.getLong(0), data.getString(1),
                        data.getString(2));
                vehicles.add(vehicleFound);
            }
        }

        return vehicles;
    }
    public boolean addCar(Car vehicle ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        carTable  = new CarTable();
        contentValues = new ContentValues();

        contentValues.put(carTable.getAttributeId().name, vehicle.getId());
        contentValues.put(carTable.getRegNumber().name,vehicle.getRegistrationNumber());
        contentValues.put(carTable.getCarType().name,vehicle.getCarType());

        try {
            returned = localDatabase.insert(carTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }
    public Car findCarById(long id) {
        Car vehicleFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(carTable.getTableName(),
                carTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                vehicleFound = CarFactory.getCar(data.getLong(0), data.getString(1),
                        data.getString(2));
            }
        }
        return vehicleFound;
    }


}










