package za.co.whcb.tp2.rikitours.repository.local.tour;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.tour.SeasonDescriptionTable;
import za.co.whcb.tp2.rikitours.config.database.table.tour.SeasonTable;
import za.co.whcb.tp2.rikitours.domain.tour.SeasonDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Seasons;
import za.co.whcb.tp2.rikitours.factories.tour.SeasonDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.SeasonFactory;

/**
 * Created by Encore on 10/17/2016.
 */
public class SeasonsRepo extends SQLiteOpenHelper {
    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static SeasonTable seasonTable;
    private static SeasonDescriptionTable seasonDescriptionTable;


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

    public ArrayList<Seasons> getAllSeasons() {
        ArrayList<Seasons> season = new ArrayList<>();

        Seasons seasonFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(seasonTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                seasonFound = SeasonFactory.getSeasons(data.getLong(0), data.getString(1), findSeasonDescriptionById(data.getLong(2)));
                season.add(seasonFound);
            }
        }
        return season;
    }

    public boolean updateSeason(Seasons updatedSeason, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(seasonTable.getAttributeDescriptionId().name,updatedSeason.getDescription().getId());
        contentValues.put(seasonTable.getAttributeName().name,updatedSeason.getName());

        try {

            returned =  localDatabase.update(seasonDescriptionTable.getTableName(),
                    contentValues, seasonDescriptionTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(seasonDescriptionTable.getTableName(),
                    seasonDescriptionTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }

    public Seasons findSeasonById(long id) {
        Seasons seasonFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(seasonTable.getTableName(),
                seasonTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                seasonFound = SeasonFactory.getSeasons(data.getLong(0), data.getString(1), findSeasonDescriptionById(data.getLong(2)));
            }
        }
        return seasonFound;
    }
    private SeasonDescription findSeasonDescriptionById(long id){
        SeasonDescription seasonDescriptionFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(seasonDescriptionTable.getTableName(),
                seasonDescriptionTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);
        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                seasonDescriptionFound = SeasonDescriptionFactory.getSeasonsDescription(data.getLong(0), data.getString(1), data.getInt(2));
            }
        }
        return seasonDescriptionFound;
    }
}
