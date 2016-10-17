package za.co.whcb.tp2.rikitours.config.database.table.tour;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by berka on 10/10/2016.
 */
public class SeasonDescriptionTable extends Table {
    public final String tableName = "seasonDescription";
    public static Attribute id = new Attribute("id", "INTEGER");
    public static Attribute description=new Attribute("description","TEXT");
    public static Attribute numberOfSeason=new Attribute("start","INTEGER");

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

    public Attribute getAttributeNumberOfSeasons() {
        return numberOfSeason;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(description);
        attributes.add(numberOfSeason);

        return  attributes;
    }
}
