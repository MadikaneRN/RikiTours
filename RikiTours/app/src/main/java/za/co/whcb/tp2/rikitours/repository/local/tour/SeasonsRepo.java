package za.co.whcb.tp2.rikitours.repository.local.tour;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.tour.SeasonTable;
import za.co.whcb.tp2.rikitours.domain.tour.Seasons;

/**
 * Created by work on 10/17/2016.
 */
public class SeasonsRepo extends SQLiteOpenHelper {
    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static SeasonTable seasonTable;


    public SeasonsRepo(Context context) {
        super(context, Database.name, null, Database.version);
        seasonTable = new SeasonTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(seasonTable.getTableName(),seasonTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + seasonTable.getTableName());
        onCreate(db);
    }

    public boolean addSeason(Seasons seasons ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        seasonTable  = new SeasonTable();
        contentValues = new ContentValues();

        contentValues.put(seasonTable.getAttributeId().name, seasons.getId());
        contentValues.put(seasonTable.getAttributeDescriptionId().name, seasons.getDescription().getId());
        contentValues.put(seasonTable.getAttributeName().name, seasons.getName());

        try {
            returned = localDatabase.insert(seasonTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public Seasons findCountryById(long id) {
        Seasons seasonFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(seasonTable.getTableName(),
                seasonTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
               /* attractionFound = AttractionFactory.getAttraction(data.getLong(0), data.getLong(1), data.getLong(2));*/
            }
        }
        return seasonFound;
    }
}
