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
import za.co.whcb.tp2.rikitours.config.database.table.customer.ContactTable;
import za.co.whcb.tp2.rikitours.domain.customer.Contact;
import za.co.whcb.tp2.rikitours.factories.customer.ContactFactory;

/**
 * Created by Game330 on 2016-10-14.
 */
public class ContactRepo extends SQLiteOpenHelper {

    private SQLiteDatabase localDatabase;
    private ContentValues contentValues;
    private static ContactTable contactTable ;


    public ContactRepo(Context context) {
        super(context, Database.name, null, Database.version);
        contactTable = new ContactTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            final String query = Converter.toCreateTableQuery(contactTable.getTableName(),contactTable.getAllAttributes());
            db.execSQL(query);
        }
        catch (Exception ex) {
            Log.d("SQL ERROR", ex.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + contactTable.getTableName());
        onCreate(db);
    }

    public boolean addCountry(Contact contact ) {
        long returned ;
        localDatabase = this.getWritableDatabase();
        contactTable  = new ContactTable();
        contentValues = new ContentValues();

        contentValues.put(contactTable.getAttributeId().name, contact.getId());
        contentValues.put(contactTable.getAttributeLandlineNo().name, contact.getLandlineNo());
        contentValues.put(contactTable.getAttributePhoneNo().name, contact.getPhoneNo());


        try {
            returned = localDatabase.insert(contactTable.getTableName(), null, contentValues);
        }catch (Exception ex) {
            returned = 0;
            Log.d("exception ::::",ex.getMessage());

        }

        return (returned != -1) ? true : false;
    }

    public Contact findContactById(long id) {
        Contact contactFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAllWhere(contactTable.getTableName(),
                contactTable.getAttributeId(), String.valueOf(id));
        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                contactFound = ContactFactory.getContact(data.getLong(0), data.getString(1),
                        data.getString(2));
            }
        }
        return contactFound;
    }

    public ArrayList<Contact> getAllCountries() {
        ArrayList<Contact> contacts= new ArrayList<>();
        Contact contactFound = null;
        localDatabase = this.getReadableDatabase();
        String query = Converter.toSelectAll(contactTable.getTableName());

        Cursor data = localDatabase.rawQuery(query, null);

        if(data.getCount() != 0) {
            while (data.moveToNext()) {
                contactFound = ContactFactory.getContact(data.getLong(0), data.getString(1),
                        data.getString(2));
                contacts.add(contactFound);
            }
        }

        return contacts;
    }

    public boolean updateContact(Contact updatedContact, long id) {

        long returned ;
        localDatabase = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(contactTable.getAttributeId().name,updatedContact.getId());
        contentValues.put(contactTable.getAttributePhoneNo().name,updatedContact.getLandlineNo());
        contentValues.put(contactTable.getAttributeLandlineNo().name,updatedContact.getLandlineNo());

        try {

            returned =  localDatabase.update(contactTable.getTableName(),
                    contentValues,contactTable.getPrimaryKey().name + " = ?",
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

            returned =  localDatabase.delete(contactTable.getTableName(),
                    contactTable.getPrimaryKey().name + " = ?",
                    new String[]{String.valueOf(id)});

        } catch (Exception ex) {
            returned = 0;

        }

        return (returned != 0) ? true : false;

    }

}
