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
import za.co.whcb.tp2.rikitours.config.database.table.rental.RentalTable;
import za.co.whcb.tp2.rikitours.config.database.table.rental.ReservationTable;
import za.co.whcb.tp2.rikitours.config.database.table.rental.VehicleTable;
import za.co.whcb.tp2.rikitours.domain.Contacts;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.rental.Rental;
import za.co.whcb.tp2.rikitours.domain.rental.Reservation;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;
import za.co.whcb.tp2.rikitours.factories.customer.CustomerFactory;
import za.co.whcb.tp2.rikitours.factories.rental.RentalFactory;
import za.co.whcb.tp2.rikitours.factories.rental.ReservationsFactory;
import za.co.whcb.tp2.rikitours.factories.rental.VehicleFactory;

/**
 * Created by Lindo on 10/17/2016.
 */
public class RentalRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static RentalTable rentalTable;
    private static ReservationTable reservationTable;
    private static CustomerTable customerTable;
    private static VehicleTable vehicleTable;

    public RentalRepo(Context context) {
        super(context, Database.name, null, Database.version);
        rentalTable = new RentalTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(rentalTable.getTableName(),rentalTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + rentalTable.getTableName());
        onCreate(db);
    }

    public boolean addRenatl(Rental rental ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        rentalTable  = new RentalTable();
        contentValues = new ContentValues();

        contentValues.put(rentalTable.getAttributeId().name, rental.getId());
        contentValues.put(rentalTable.getReservationID().name, rental.getReservation().getId());
        contentValues.put(rentalTable.getStatus().name, rental.getStatus());

        try {
            returned = localDatabase.insert(rentalTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public Rental findRentalById(long id) {
        Rental rentalFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(rentalTable.getTableName(),
                rentalTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                rentalFound = RentalFactory.getRental(data.getLong(0), findReservationById(data.getInt(1)),
                        data.getString(2));
            }
        }
        return rentalFound;
    }

    public Reservation findReservationById(long id) {
        Reservation reservationFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(reservationTable.getTableName(),
                reservationTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

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
                Contacts contact = null;
                customerFound = CustomerFactory.getCustomer(data.getLong(0), data.getString(1), data.getString(2), data.getString(3));
                //,contact
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

    public ArrayList<Rental> getAllRentals() {
        ArrayList<Rental> rentalArrayList = new ArrayList<>();
        Rental rentalFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(rentalTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                rentalFound =  RentalFactory.getRental(data.getLong(0), findReservationById(data.getInt(1)),
                        data.getString(2));
                rentalArrayList.add(rentalFound);
            }
        }

        return rentalArrayList;
    }

    public boolean updateRental(Rental updatedRental, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(rentalTable.getReservationID().name, updatedRental.getReservation().getId());
        contentValues.put(rentalTable.getStatus().name, updatedRental.getStatus());

        try {

            returned =  localDatabase.update(rentalTable.getTableName(),
                    contentValues,rentalTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(rentalTable.getTableName(),
                    rentalTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}
