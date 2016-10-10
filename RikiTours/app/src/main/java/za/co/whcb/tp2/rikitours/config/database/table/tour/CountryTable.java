package za.co.whcb.tp2.rikitours.config.database.table.tour;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by work on 10/10/2016.
 */
public class CountryTable extends Table {
    public final String tableName = "attractions";
    public static Attribute id = new Attribute("id", "INTEGER");
    public static Attribute name = new Attribute("name", "TEXT");
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

    public Attribute getName() {
        return name;
    }

    public Attribute getDescription() {
        return description;
    }

    public Attribute getImage() {
        return image;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(name);
        attributes.add(description);
        attributes.add(image);

        return attributes;
    }
}
