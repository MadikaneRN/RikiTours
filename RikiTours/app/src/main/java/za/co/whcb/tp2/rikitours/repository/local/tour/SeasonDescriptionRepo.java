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
import za.co.whcb.tp2.rikitours.domain.tour.SeasonDescription;
import za.co.whcb.tp2.rikitours.factories.tour.SeasonDescriptionFactory;

/**
 * Created by Encore on 10/17/2016.
 */
public class SeasonDescriptionRepo extends SQLiteOpenHelper {
    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static SeasonDescriptionTable seasonDescriptionTable;


    public SeasonDescriptionRepo(Context context) {
        super(context, Database.name, null, Database.version);
        seasonDescriptionTable = new SeasonDescriptionTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(seasonDescriptionTable.getTableName(),seasonDescriptionTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + seasonDescriptionTable.getTableName());
        onCreate(db);
    }

    public boolean addSeasonDescription(SeasonDescription seasonDescription ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        seasonDescriptionTable  = new SeasonDescriptionTable();
        contentValues = new ContentValues();

        contentValues.put(seasonDescriptionTable.getAttributeId().name, seasonDescription.getId());
        contentValues.put(seasonDescriptionTable.getAttributeDescription().name, seasonDescription.getDescription());
        contentValues.put(seasonDescriptionTable.getAttributeNumberOfSeasons().name, seasonDescription.getNumberOfSeason());

        try {
            returned = localDatabase.insert(seasonDescriptionTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public ArrayList<SeasonDescription> getAllSeasonDescriptions() {
        ArrayList<SeasonDescription> seasonDescription = new ArrayList<>();

        SeasonDescription seasonDescriptionFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(seasonDescriptionTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                seasonDescriptionFound = SeasonDescriptionFactory.getSeasonsDescription(data.getLong(0), data.getString(1), data.getInt(2));
                seasonDescription.add(seasonDescriptionFound);
            }
        }
        return seasonDescription;
    }

    public boolean updateSeasonDescription(SeasonDescription updatedSeasonDescription, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(seasonDescriptionTable.getAttributeDescription().name,updatedSeasonDescription.getDescription());
        contentValues.put(seasonDescriptionTable.getAttributeNumberOfSeasons().name,updatedSeasonDescription.getNumberOfSeason());

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


    public SeasonDescription findSeaseonDescriptionById(long id) {
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
