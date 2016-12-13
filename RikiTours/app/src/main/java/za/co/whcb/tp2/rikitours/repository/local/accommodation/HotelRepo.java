package za.co.whcb.tp2.rikitours.repository.local.accommodation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.accommodation.HotelTable;
import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;
import za.co.whcb.tp2.rikitours.factories.accommodation.HotelFactory;

/**
 * Created by berka on 11/26/2016.
 */
public class HotelRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static HotelTable hotelTable;


    public HotelRepo(Context context) {
        super(context, Database.name, null, Database.version);
        hotelTable = new HotelTable();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(hotelTable.getTableName(),hotelTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + hotelTable.getTableName());
        onCreate(db);
    }


    public boolean addHotel(Hotel hotel ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        hotelTable  = new HotelTable();
        contentValues = new ContentValues();

        contentValues.put(hotelTable.getAttributeId().name,hotel.getId());
        contentValues.put(hotelTable.getName().name,hotel.getName());
        contentValues.put(hotelTable.getStar().name,hotel.getName());
        contentValues.put(hotelTable.getDescription().name, hotel.getDescription());

        try {
            returned = localDatabase.insert(hotelTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }
    public boolean deleteById(long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();

        try {

            returned =  localDatabase.delete(hotelTable.getTableName(),
                    hotelTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
    public Hotel findHotelById(long id) {
        Hotel hotelFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(hotelTable.getTableName(),
                hotelTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);



        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                hotelFound = HotelFactory.getHotel(data.getLong(0),data.getString(1),data.getString(2),data.getString(3));
            }
        }
        return hotelFound;
    }

    public ArrayList<Hotel> getAllHotels() {
        ArrayList<Hotel> hotelArrayList = new ArrayList<>();
        Hotel hotelFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(hotelTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {

                hotelFound = HotelFactory.getHotel(data.getLong(0),data.getString(1),data.getString(2),data.getString(3));
                hotelArrayList.add(hotelFound);

            }
        }

        return hotelArrayList;
    }

    public boolean updateHotel(Hotel updatedHotel, long id) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();

        contentValues.put(hotelTable.getName().name,updatedHotel.getName() );
        contentValues.put(hotelTable.getDescription().name,updatedHotel.getName() );
        contentValues.put(hotelTable.getStar().name,updatedHotel.getStar());
        contentValues.put(hotelTable.getDescription().name,updatedHotel.getDescription());

        try {

            returned =  localDatabase.update(hotelTable.getTableName(),
                    contentValues,hotelTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;
    }



}
