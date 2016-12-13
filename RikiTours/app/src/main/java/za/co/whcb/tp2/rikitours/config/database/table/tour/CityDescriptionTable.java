package za.co.whcb.tp2.rikitours.config.database.table.tour;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by work on 10/10/2016.
 */
public class CityDescriptionTable extends Table {

    public final String tableName = "CityDescription";
    public static Attribute id = new Attribute("id", "INTEGER");
    private final Attribute countryId = new Attribute("countryId", "INTEGER");
    public static Attribute description = new Attribute("description", "TEXT");



    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public Attribute getPrimaryKey() {
        return id;
    }

    public Attribute getAttributeId() {
        return id;
    }

    public Attribute getCountryId() {
        return countryId;
    }
    public Attribute getDescription() {
        return description;
    }


    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(countryId);
        attributes.add(description);



        return  attributes;
    }
}
