package za.co.whcb.tp2.rikitours.config.database.table.common;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by work on 10/8/2016.
 */
public class CountryTable extends Table {

    private final String tableName = "countries";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute name = new Attribute("country_name", "TEXT");
    private final Attribute description = new Attribute("description", "TEXT");
    private final Attribute image = new Attribute("image", "TEXT");



    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public Attribute getPrimaryKey() {
        return id;
    }

    public Attribute getAttrubeId() {
        return id;
    }

    public Attribute getAttributeName() {
        return name;
    }

    public Attribute getAttributeImage() {
        return image;
    }

    public Attribute getAttributeDescription() {
        return description;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(name);
        attributes.add(description);
        attributes.add(image);

        return  attributes;
    }

}