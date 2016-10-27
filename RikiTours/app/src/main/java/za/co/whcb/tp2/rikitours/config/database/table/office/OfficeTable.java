package za.co.whcb.tp2.rikitours.config.database.table.office;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by Lindo on 10/16/2016.
 */
public class OfficeTable extends Table{
    private final String tableName = "office";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute city = new Attribute("city", "TEXT");
    private final Attribute location = new Attribute("location", "TEXT");

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
    public Attribute getAttributeCity() {
        return city;
    }
    public Attribute getAttributeLocation() {
        return location;
    }
    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(city);
        attributes.add(location);

        return  attributes;
    }
}
