package za.co.whcb.tp2.rikitours.repository.local.tour;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.tour.TourTable;
import za.co.whcb.tp2.rikitours.domain.tour.Tour;

/**
 * Created by work on 10/17/2016.
 */
public class TourRepo extends SQLiteOpenHelper {
    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static TourTable tourTable;

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

    public Tour findSeasonById(long id) {
        Tour tourFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(tourTable.getTableName(),
                tourTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
               /* attractionFound = AttractionFactory.getAttracion(data.getLong(0), data.getLong(1), data.getLong(2));*/
            }
        }
        return tourFound;
    }
}
