package za.co.whcb.tp2.rikitours.repository.local.tour;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.tour.AttractionTable;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionFactory;

/**
 * Created by work on 10/10/2016.
 */
public class AttractionsRepo extends SQLiteOpenHelper {
    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static AttractionTable attractionTable ;


    public AttractionsRepo(Context context) {
        super(context, Database.name, null, Database.version);
        attractionTable = new AttractionTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(attractionTable.getTableName(),attractionTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + attractionTable.getTableName());
        onCreate(db);
    }

    public boolean addCountry(Attraction attraction ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        attractionTable  = new AttractionTable();
        contentValues = new ContentValues();

        contentValues.put(attractionTable.getAttributeId().name, attraction.getId());
        contentValues.put(attractionTable.getCountryId().name, attraction.getCountry().getId());
        contentValues.put(attractionTable.getAttractionDescriptionId().name, attraction.getAttractionDescription().getId());

        try {
            returned = localDatabase.insert(attractionTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public Attraction findCountryById(long id) {
        Attraction attractionFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(attractionTable.getTableName(),
                attractionTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
               /* attractionFound = AttractionFactory.getAttracion(data.getLong(0), data.getLong(1), data.getLong(2));*/
            }
        }
        return attractionFound;
    }
}
