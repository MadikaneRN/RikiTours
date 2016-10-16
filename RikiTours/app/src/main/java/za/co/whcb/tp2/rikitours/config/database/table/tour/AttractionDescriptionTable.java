package za.co.whcb.tp2.rikitours.config.database.table.tour;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by work on 10/10/2016.
 */
public class AttractionDescriptionTable extends Table{
    public final String tableName = "AttractionDescripition";
    public static Attribute id = new Attribute("id", "INTEGER");
    public static Attribute name = new Attribute("name", "TEXT");
    public static Attribute city = new Attribute("city", "TEXT");
    public static Attribute description = new Attribute("description", "TEXT");
    public static Attribute image = new Attribute("image", "TEXT");

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

    public Attribute getNameId() {
        return name;
    }
    public Attribute getCityId() {
        return city;
    }

    public Attribute getdescription() {
        return description;
    }

    public Attribute getImageId() {
        return image;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(name);
        attributes.add(city);
        attributes.add(description);
        attributes.add(image);

        return  attributes;
    }
}
