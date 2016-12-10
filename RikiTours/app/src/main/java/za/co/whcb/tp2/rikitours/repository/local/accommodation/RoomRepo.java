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
import za.co.whcb.tp2.rikitours.config.database.table.accommodation.RoomTable;
import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;
import za.co.whcb.tp2.rikitours.domain.accommodation.Room;
import za.co.whcb.tp2.rikitours.factories.accommodation.HotelFactory;
import za.co.whcb.tp2.rikitours.factories.accommodation.RoomFactory;

/**
 * Created by lindo on 2016-12-03.
 */
public class RoomRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static RoomTable roomTable ;
    private static HotelTable hotelTable;

    public RoomRepo(Context context) {
        super(context, Database.name, null, Database.version);
        roomTable = new RoomTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(roomTable.getTableName(),roomTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + roomTable.getTableName());
        onCreate(db);
    }

    public boolean addRoom(Room room ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        roomTable  = new RoomTable();
        contentValues = new ContentValues();

        contentValues.put(roomTable.getAttributeId().name, room.getId());
        contentValues.put(roomTable.getAttributeSize().name, room.getSize());
        contentValues.put(roomTable.getAttributeType().name, room.getType());
        contentValues.put(roomTable.getAttributeDescription().name, room.getDescription());
        contentValues.put(roomTable.getAttributeHoteID().name, room.getHotel().getId());

        try {
            returned = localDatabase.insert(roomTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public Room findRoomById(long id) {
        Room roomFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(roomTable.getTableName(),
                roomTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                roomFound = RoomFactory.getRoom(data.getLong(0), data.getString(1),
                        data.getString(2), data.getString(3), findHotelById(data.getLong(1)));
            }
        }
        return roomFound;
    }

    public Hotel findHotelById(long id) {
        Hotel hotelFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(hotelTable.getTableName(),
                hotelTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                hotelFound = HotelFactory.getHotel(data.getLong(0), data.getString(1),
                        data.getString(2), data.getString(3));
            }
        }
        return hotelFound;
    }

    public ArrayList<Room> getAllRooms() {
        ArrayList<Room> rooms = new ArrayList<>();
        Room roomFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(roomTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                roomFound = RoomFactory.getRoom(data.getLong(0), data.getString(1),
                        data.getString(2), data.getString(3), findHotelById(data.getLong(1)));
                rooms.add(roomFound);
            }
        }

        return rooms;
    }

    public boolean updateRoom(Room updatedRoom, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(roomTable.getAttributeSize().name, updatedRoom.getSize());
        contentValues.put(roomTable.getAttributeType().name, updatedRoom.getType());
        contentValues.put(roomTable.getAttributeDescription().name, updatedRoom.getDescription());
        contentValues.put(roomTable.getAttributeHoteID().name, updatedRoom.getHotel().getId());;

        try {

            returned =  localDatabase.update(roomTable.getTableName(),
                    contentValues,roomTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(roomTable.getTableName(),
                    roomTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}
