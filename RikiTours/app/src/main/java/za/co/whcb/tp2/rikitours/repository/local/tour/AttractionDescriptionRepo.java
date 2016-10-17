package za.co.whcb.tp2.rikitours.repository.local.tour;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.tour.AttractionDescriptionTable;
import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionDescriptionFactory;

/**
 * Created by Shaun Mesias on 2016/10/17.
 */
public class AttractionDescriptionRepo extends SQLiteOpenHelper {
    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static AttractionDescriptionTable attractionTable ;


    public AttractionDescriptionRepo(Context context) {
        super(context, Database.name, null, Database.version);
        attractionTable = new AttractionDescriptionTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(attractionTable.getTableName(), attractionTable.getAllAttributes());
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

    public boolean addAttractionDescription(AttractionDescription attraction ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        attractionTable  = new AttractionDescriptionTable();
        contentValues = new ContentValues();

        contentValues.put(attractionTable.getAttributeId().name, attraction.getId());
        contentValues.put(attractionTable.getNameId().name, attraction.getName());
        contentValues.put(attractionTable.getCityId().name, attraction.getCity());
        contentValues.put(attractionTable.getdescription().name, attraction.getDescription());
        contentValues.put(attractionTable.getImageId().name, attraction.getImage());

        try {
            returned = localDatabase.insert(attractionTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public AttractionDescription findCountryById(long id) {
        AttractionDescription attractionFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(attractionTable.getTableName(),
                attractionTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                attractionFound = AttractionDescriptionFactory.getAttracionDescription(data.getLong(0), data.getString(1), data.getString(2), data.getString(3), data.getString(4));
            }
        }
        return attractionFound;
    }
}
