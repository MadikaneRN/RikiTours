//package za.co.whcb.tp2.rikitours.repository.local.tour;
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
//import za.co.whcb.tp2.rikitours.config.database.table.tour.CityDescriptionTable;
//import za.co.whcb.tp2.rikitours.config.database.table.tour.CityTable;
//import za.co.whcb.tp2.rikitours.domain.tour.City;
//import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
//import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
//import za.co.whcb.tp2.rikitours.factories.tour.CityFactory;
//
///**
// * Created by Shaun Mesias on 2016/10/17.
// */
//public class CityRepo extends SQLiteOpenHelper {
//    private SQLiteDatabase localDatabase;
//    private ContentValues contentValues;
//    private static CityTable cityTable;
//    private static CityDescriptionTable descriptionTable;
//
//
//    public CityRepo(Context context) {
//        super(context, Database.name, null, Database.version);
//        cityTable = new CityTable();
//        descriptionTable = new CityDescriptionTable();
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        try {
//            final String query = Converter.toCreateTableQuery(cityTable.getTableName(), cityTable.getAllAttributes());
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
//        db.execSQL("DROP TABLE IF EXITS " + cityTable.getTableName());
//        onCreate(db);
//    }
//
//    public boolean addCity(City city ) {
//        long returned ;
//        localDatabase = this.getWritableDatabase();
//        cityTable  = new CityTable();
//        contentValues = new ContentValues();
//
//        contentValues.put(cityTable.getAttributeId().name, city.getId());
//        contentValues.put(cityTable.getNameId().name, city.getName());
//        contentValues.put(cityTable.getDescriptionId().name, city.getDescription().getId());
//
//        try {
//            returned = localDatabase.insert(cityTable.getTableName(), null, contentValues);
//        }catch (Exception ex) {
//            returned = 0;
//            Log.d("exception ::::",ex.getMessage());
//
//        }
//
//        return (returned != -1) ? true : false;
//    }
//
//    public City findCityById(long id) {
//        City cityFound = null;
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = Converter.toSelectAllWhere(cityTable.getTableName(),
//                cityTable.getAttributeId(), String.valueOf(id));
//        Cursor data = db.rawQuery(query, null);
//
//        if(data.getCount() != 0) {
//            while (data.moveToNext()) {
//                cityFound = CityFactory.getCity(data.getLong(0), data.getString(1), findCityDescriptionById(data.getLong(2)));
//            }
//        }
//        return cityFound;
//    }
//
//    private CityDescription findCityDescriptionById(long id) {
//        CityDescription descriptionFound = null;
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = Converter.toSelectAllWhere(descriptionTable.getTableName(),
//                descriptionTable.getAttributeId(), String.valueOf(id));
//        Cursor data = db.rawQuery(query, null);
//
//        if(data.getCount() != 0) {
//            while (data.moveToNext()) {
//
//                descriptionFound = CityDescriptionFactory.getCityDescription(data.getLong(0), data.getString(1), data.getString(2));
//            }
//        }
//        return descriptionFound;
//    }
//
//    public ArrayList<City> getAllCities() {
//        ArrayList<City> descriptions = new ArrayList<>();
//        City CityFound = null;
//        localDatabase = this.getReadableDatabase();
//        String query = Converter.toSelectAll(cityTable.getTableName());
//
//        Cursor data = localDatabase.rawQuery(query, null);
//
//        if(data.getCount() != 0) {
//            while (data.moveToNext()) {
//                CityFound = CityFactory.getCity(data.getLong(0), data.getString(1), findCityDescriptionById(data.getLong(2)));
//                descriptions.add(CityFound);
//            }
//        }
//
//        return descriptions;
//    }
//
//    public boolean updateCity(City updatedCity, long id) {
//
//        long returned ;
//        localDatabase = this.getWritableDatabase();
//        contentValues = new ContentValues();
//        contentValues.put(cityTable.getNameId().name,updatedCity.getName());
//        contentValues.put(cityTable.getDescriptionId().name,updatedCity.getDescription().getId());
//
//        try {
//
//            returned =  localDatabase.update(cityTable.getTableName(),
//                    contentValues, cityTable.getPrimaryKey().name + " = ?",
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
//            returned =  localDatabase.delete(cityTable.getTableName(),
//                    cityTable.getPrimaryKey().name + " = ?",
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
