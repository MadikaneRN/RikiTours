package za.co.whcb.tp2.rikitours.repository.local.office;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.office.OfficeTable;
import za.co.whcb.tp2.rikitours.domain.office.Office;
import za.co.whcb.tp2.rikitours.factories.office.OfficeFactory;

/**
 * Created by Lindo on 10/16/2016.
 */
public class OfficeRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static OfficeTable officeTable;

    public OfficeRepo(Context context) {
        super(context, Database.name, null, Database.version);
        officeTable = new OfficeTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(officeTable.getTableName(),officeTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + officeTable.getTableName());
        onCreate(db);
    }

    public boolean addOffice(Office office ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        officeTable  = new OfficeTable();
        contentValues = new ContentValues();

        contentValues.put(officeTable.getAttributeId().name, office.getId());
        contentValues.put(officeTable.getAttributeCity().name, office.getCity());
        contentValues.put(officeTable.getAttributeLocation().name, office.getLocation());

        try {
            returned = localDatabase.insert(officeTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }
    public Office findOfficeById(long id) {
        Office officeFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(officeTable.getTableName(),
                officeTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                officeFound = OfficeFactory.getOffice(data.getLong(0), data.getString(1),
                        data.getString(2));
            }
        }
        return officeFound;
    }
    public ArrayList<Office> getAllOffice() {
        ArrayList<Office> officeArrayList = new ArrayList<>();
        Office officeFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(officeTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                officeFound = OfficeFactory.getOffice(data.getLong(0), data.getString(1),
                        data.getString(2));
                officeArrayList.add(officeFound);
            }
        }

        return officeArrayList;
    }
    public boolean updateOffice(Office updatedOffice, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(officeTable.getAttributeCity().name,updatedOffice.getCity());
        contentValues.put(officeTable.getAttributeLocation().name,updatedOffice.getLocation());

        try {

            returned =  localDatabase.update(officeTable.getTableName(),
                    contentValues,officeTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(officeTable.getTableName(),
                    officeTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}
