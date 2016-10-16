package za.co.whcb.tp2.rikitours.repository.local.customer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.Database;
import za.co.whcb.tp2.rikitours.config.database.table.customer.EmergencyContactTable;
import za.co.whcb.tp2.rikitours.domain.customer.EmergencyContact;
import za.co.whcb.tp2.rikitours.factories.customer.EmergencyContactFactory;

/**
 * Created by Game330 on 2016-10-15.
 */
public class EmergencyContactRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static EmergencyContactTable emergencyContactTable;


    public EmegencyContactRepo(Context context) {
        super(context, Database.name, null, Database.version);
        emergencyContactTable = new EmergencyContactTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(emergencyContactTable.getTableName(),emergencyContactTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + emergencyContactTable.getTableName());
        onCreate(db);
    }

    public boolean addEmergencyContact(EmergencyContact emergencyContact) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        emergencyContactTable  = new EmergencyContactTable();
        contentValues = new ContentValues();

        contentValues.put(emergencyContactTable.getAttributeId().name, emergencyContact.getId());
        contentValues.put(emergencyContactTable.getAttributeName().name, emergencyContact.getName());
        contentValues.put(emergencyContactTable.getAttributeSurname().name, emergencyContact.getSurname());
        contentValues.put(emergencyContactTable.getAttributePhoneNo().name, emergencyContact.getPhoneNo());
        contentValues.put(emergencyContactTable.getAttributeLandllieNo().name, emergencyContact.getLandlineNo());
        contentValues.put(emergencyContactTable.getAttributeRelationship().name, emergencyContact.getRelationship());

        try {
            returned = localDatabase.insert(emergencyContactTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public EmergencyContact findEmergencyContactById(long id) {
        EmergencyContact contactFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(emergencyContactTable.getTableName(),
                emergencyContactTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                contactFound = EmergencyContactFactory.getContact(data.getString(1), data.getString(1),
                        data.getString(2), data.getString(3),data.getString(3),data.getString(3));
            }
        }
        return contactFound;
    }

    public ArrayList<EmergencyContact> getAllEmergencyContacts() {
        ArrayList<EmergencyContact> emergencyContacts = new ArrayList<>();
        EmergencyContact contactFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(emergencyContactTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                contactFound = EmergencyContactFactory.getContact(data.getString(0), data.getString(1),
                        data.getString(2), data.getString(3),data.getString(3),data.getString(4));
                emergencyContacts.add(contactFound);
            }
        }

        return emergencyContacts;
    }

    public boolean updateEmergencyContact(EmergencyContact updatedEmergencyContact, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();

        contentValues.put(emergencyContactTable.getAttributeId().name, updatedEmergencyContact.getId());
        contentValues.put(emergencyContactTable.getAttributeName().name, updatedEmergencyContact.getName());
        contentValues.put(emergencyContactTable.getAttributeSurname().name, updatedEmergencyContact.getSurname());
        contentValues.put(emergencyContactTable.getAttributePhoneNo().name, updatedEmergencyContact.getPhoneNo());
        contentValues.put(emergencyContactTable.getAttributeLandllieNo().name, updatedEmergencyContact.getLandlineNo());
        contentValues.put(emergencyContactTable.getAttributeRelationship().name, updatedEmergencyContact.getRelationship());
        try {

            returned =  localDatabase.update(emergencyContactTable.getTableName(),
                    contentValues,emergencyContactTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(emergencyContactTable.getTableName(),
                    emergencyContactTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }
}
