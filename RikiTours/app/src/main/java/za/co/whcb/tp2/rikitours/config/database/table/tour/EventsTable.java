package za.co.whcb.tp2.rikitours.config.database.table.tour;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by work on 10/10/2016.
 */
public class EventsTable extends Table {

    public final String tableName = "Events";
    public static Attribute id = new Attribute("id", "INTEGER");
    public static Attribute descriptionId = new Attribute("descriptionId", "INTEGER");
    public static Attribute name = new Attribute("name", "TEXT");

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

    public Attribute getAttributeName() {
        return name;
    }

    public Attribute getDescriptionId() {
        return descriptionId;
    }


    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(descriptionId);
        attributes.add(name);

        return  attributes;
    }
}
