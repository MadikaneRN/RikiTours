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
import za.co.whcb.tp2.rikitours.config.database.table.customer.CustomerTable;
import za.co.whcb.tp2.rikitours.config.database.table.rental.ReservationTable;
import za.co.whcb.tp2.rikitours.config.database.table.rental.VehicleTable;
import za.co.whcb.tp2.rikitours.domain.Contacts;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.rental.Reservation;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;
import za.co.whcb.tp2.rikitours.factories.customer.CustomerFactory;
import za.co.whcb.tp2.rikitours.factories.rental.ReservationsFactory;
import za.co.whcb.tp2.rikitours.factories.rental.VehicleFactory;

/**
 * Created by Lindo on 10/17/2016.
 */
public class ReservationRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private ReservationTable reservationTable;
    private static CustomerTable customerTable;
    private static VehicleTable vehicleTable;

    public ReservationRepo(Context context) {

        super(context, Database.name, null, Database.version);
        reservationTable = new ReservationTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(reservationTable.getTableName(),reservationTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + reservationTable.getTableName());
        onCreate(db);
    }

    public boolean addReservation(Reservation reservation) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        reservationTable  = new ReservationTable();
        contentValues = new ContentValues();

        contentValues.put(reservationTable.getAttributeId().name, reservation.getId());
        contentValues.put(reservationTable.getCustomerID().name, reservation.getCustomer().getId());
        contentValues.put(reservationTable.getVehicleID().name, reservation.getVehicle().getId());

        try {
            returned = localDatabase.insert(reservationTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public Reservation findReservationById(long id) {
        Reservation reservationFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(reservationTable.getTableName(),
                reservationTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);



        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                reservationFound = ReservationsFactory.getReservations(data.getLong(0), findCustomerById(data.getLong(1)), findVehicleById(data.getLong(2)), data.getString(3), data.getString(4), data.getDouble(5));
            }
        }
        return reservationFound;
    }

    private Customer findCustomerById(long id) {
        Customer customerFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(customerTable.getTableName(),
                customerTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                Contacts contacts = null;
                customerFound = CustomerFactory.getCustomer(data.getLong(0), data.getString(1), data.getString(2), data.getString(3),contacts);
            }
        }
        return customerFound;
    }

    private Vehicle findVehicleById(long id) {
        Vehicle vehicleFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(vehicleTable.getTableName(),
                vehicleTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {

                vehicleFound = VehicleFactory.getVehicle(data.getLong(0), data.getString(1), data.getString(2), data.getString(3));
            }
        }
        return vehicleFound;
    }

    public ArrayList<Reservation> getAllReservations() {
        ArrayList<Reservation> reservationArrayList = new ArrayList<>();
        Reservation reservationFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(reservationTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                reservationFound = ReservationsFactory.getReservations(data.getLong(0), findCustomerById(data.getLong(1)), findVehicleById(data.getLong(2)), data.getString(3), data.getString(4), data.getDouble(5));
                reservationArrayList.add(reservationFound);
            }
        }

        return reservationArrayList;
    }

    public boolean updateReservation(Reservation updatedReservation, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(reservationTable.getCustomerID().name, updatedReservation.getCustomer().getId());
        contentValues.put(reservationTable.getVehicleID().name, updatedReservation.getVehicle().getId());

        try {

            returned =  localDatabase.update(reservationTable.getTableName(),
                    contentValues,reservationTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(reservationTable.getTableName(),
                    reservationTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}
