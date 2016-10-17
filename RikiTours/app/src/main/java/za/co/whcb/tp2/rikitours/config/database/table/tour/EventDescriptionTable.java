package za.co.whcb.tp2.rikitours.config.database.table.tour;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Table;
import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
/**
 * Created by Encore on 10/10/2016.
 */
public class EventDescriptionTable extends Table {
    public final String tableName = "vventDescription";
    public static Attribute id = new Attribute("id", "INTEGER");
    public static Attribute description=new Attribute("description","TEXT");
    public static Attribute start=new Attribute("start","TEXT");
    public static Attribute end=new Attribute("end","TEXT");
    public static Attribute countryId=new Attribute("countryId","NUMBER");

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

    public Attribute getAttributeDescription() {
        return description;
    }

    public Attribute getAttributeStart() {
        return start;
    }

    public Attribute getAttributeEnd() {
        return end;
    }

    public Attribute getAttributeCountryId(){return countryId;}

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(description);
        attributes.add(start);
        attributes.add(end);
        attributes.add(countryId);

        return  attributes;
    }
}
