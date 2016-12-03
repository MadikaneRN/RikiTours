package za.co.whcb.tp2.rikitours.repository.local.accommodation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.accommodation.HotelTable;
import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;
import za.co.whcb.tp2.rikitours.factories.accommodation.HotelFactory;

/**
 * Created by bishop v on 2016-12-03.
 */
public class HotelRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static HotelTable hotelTable ;

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

        contentValues.put(hotelTable.getAttributeId().name, hotel.getId());
        contentValues.put(hotelTable.getAttributeName().name, hotel.getName());
        contentValues.put(hotelTable.getAttributeStar().name, hotel.getStar());
        contentValues.put(hotelTable.getAttributeDescription().name, hotel.getDescription());

        try {
            returned = localDatabase.insert(hotelTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
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
}
