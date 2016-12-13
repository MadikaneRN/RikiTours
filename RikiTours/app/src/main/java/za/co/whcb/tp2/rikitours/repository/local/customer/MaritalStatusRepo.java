//package za.co.whcb.tp2.rikitours.repository.local.customer;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//
//import java.util.ArrayList;
//
//import za.co.whcb.tp2.rikitours.common.Converter;
//import za.co.whcb.tp2.rikitours.config.database.Database;
//import za.co.whcb.tp2.rikitours.config.database.table.customer.MaritalStatusTable;
//import za.co.whcb.tp2.rikitours.domain.customer.MaritalStatus;
//import za.co.whcb.tp2.rikitours.factories.customer.MaritalStatusFactory;
//
///**
// * Created by Game330 on 2016-10-16.
// */
//public class MaritalStatusRepo extends SQLiteOpenHelper {
//
//    private SQLiteDatabase localDatabase;
//    private ContentValues contentValues;
//    private static MaritalStatusTable maritalStatusTable;
//
//
//    public MaritalStatusRepo(Context context) {
//        super(context, Database.name, null, Database.version);
//        maritalStatusTable = new MaritalStatusTable();
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        try {
//            final String query = Converter.toCreateTableQuery(maritalStatusTable.getTableName(),maritalStatusTable.getAllAttributes());
//            db.execSQL(query);
//        }
//        catch (Exception ex) {
//            Log.d("SQL ERROR", ex.getMessage());
//
//        }
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXITS " + maritalStatusTable.getTableName());
//        onCreate(db);
//    }
//
//    public boolean addMaritulStatus(MaritalStatus maritalStatus) {
//        long returned ;
//        localDatabase = this.getWritableDatabase();
//        maritalStatusTable  = new MaritalStatusTable();
//        contentValues = new ContentValues();
//
//        contentValues.put(maritalStatusTable.getAttributeId().name, maritalStatus.getId());
//       // contentValues.put(maritalStatusTable.getAttributeDivorced().name, maritalStatus.getIsDivorced());
//        contentValues.put(maritalStatusTable.getAttributeMarried().name, maritalStatus.getIsMarried());
//        contentValues.put(maritalStatusTable.getAttributeSingle().name, maritalStatus.getIsSingle());
//
//
//        try {
//            returned = localDatabase.insert(maritalStatusTable.getTableName(), null, contentValues);
//        }catch (Exception ex) {
//            returned = 0;
//            Log.d("exception ::::",ex.getMessage());
//
//        }
//
//        return (returned != -1) ? true : false;
//    }
//
//    public MaritalStatus findMaritalStatusById(long id) {
//        MaritalStatus contactFound = null;
//        localDatabase = this.getReadableDatabase();
//        String query = Converter.toSelectAllWhere(maritalStatusTable.getTableName(),
//                maritalStatusTable.getAttributeId(), String.valueOf(id));
//        Cursor data = localDatabase.rawQuery(query, null);
//
//        if(data.getCount() != 0) {
//            while (data.moveToNext()) {
//                contactFound = MaritalStatusFactory.getMaritalStatus(data.getString(0),data.getString(1), data.getString(1),
//                        data.getString(2));
//            }
//        }
//        return contactFound;
//    }
//
//    public ArrayList<MaritalStatus> getAllMaritalStatuses() {
//        ArrayList<MaritalStatus> emergencyContacts = new ArrayList<>();
//        MaritalStatus statusFound = null;
//        localDatabase = this.getReadableDatabase();
//        String query = Converter.toSelectAll(maritalStatusTable.getTableName());
//
//        Cursor data = localDatabase.rawQuery(query, null);
//
//        if(data.getCount() != 0) {
//            while (data.moveToNext()) {
//                statusFound = MaritalStatusFactory.getMaritalStatus(data.getString(0),data.getString(1), data.getString(1),
//                        data.getString(2));
//                emergencyContacts.add(statusFound);
//            }
//        }
//
//        return emergencyContacts;
//    }
//
//    public boolean updateMeritalStatus(MaritalStatus updatedMaritalStatus, long id) {
//
//        long returned ;
//        localDatabase = this.getWritableDatabase();
//        contentValues = new ContentValues();
//
//        contentValues.put(maritalStatusTable.getAttributeId().name, updatedMaritalStatus.getId());
//        contentValues.put(maritalStatusTable.getAttributeDivorced().name, updatedMaritalStatus.getIsDivorced());
//        contentValues.put(maritalStatusTable.getAttributeMarried().name, updatedMaritalStatus.getIsMarried());
//        contentValues.put(maritalStatusTable.getAttributeSingle().name, updatedMaritalStatus.getIsSingle());
//        try {
//
//            returned =  localDatabase.update(maritalStatusTable.getTableName(),
//                    contentValues,maritalStatusTable.getPrimaryKey().name + " = ?",
//                    new String[]{String.valueOf(id)});
//
//        } catch (Exception ex) {
//            returned = 0;
//
//        }
//
//        return (returned != 0) ? true : false;
//    }
//
//    public boolean deleteById(long id) {
//
//        long returned ;
//        localDatabase = this.getWritableDatabase();
//
//        try {
//
//            returned =  localDatabase.delete(maritalStatusTable.getTableName(),
//                    maritalStatusTable.getPrimaryKey().name + " = ?",
//                    new String[]{String.valueOf(id)});
//
//        } catch (Exception ex) {
//            returned = 0;
//
//        }
//
//        return (returned != 0) ? true : false;
//
//    }
//}
