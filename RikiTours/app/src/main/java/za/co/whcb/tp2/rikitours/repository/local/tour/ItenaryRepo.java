package za.co.whcb.tp2.rikitours.repository.local.tour;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.tour.ItenaryTable;
import za.co.whcb.tp2.rikitours.domain.tour.Itenary;

/**
 * Created by work on 10/17/2016.
 */
public class ItenaryRepo extends SQLiteOpenHelper {
    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static ItenaryTable itenaryTable;


    public ItenaryRepo(Context context) {
        super(context, Database.name, null, Database.version);
        itenaryTable = new ItenaryTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(itenaryTable.getTableName(),itenaryTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + itenaryTable.getTableName());
        onCreate(db);
    }

    public boolean addItenary(Itenary itenary ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        itenaryTable  = new ItenaryTable();
        contentValues = new ContentValues();

        contentValues.put(itenaryTable.getAttributeId().name, itenary.getId());
        contentValues.put(itenaryTable.getAttributeGroupAttractionId().name, itenary.getAttractions().toString());

        try {
            returned = localDatabase.insert(itenaryTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public Itenary findCountryById(long id) {
        Itenary itenaryFound = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(itenaryTable.getTableName(),
                itenaryTable.getAttributeId(), String.valueOf(id));
        Cursor data = db.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
               /* attractionFound = AttractionFactory.getAttraction(data.getLong(0), data.getLong(1), data.getLong(2));*/
            }
        }
        return itenaryFound;
    }
}
