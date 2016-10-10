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
    public static Attribute suburbId = new Attribute("suburb", "TEXT");
    public static Attribute nationId = new Attribute("nation", "TEXT");

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

    public Attribute getSuburbId() {
        return suburbId;
    }

    public Attribute getNationId() {
        return nationId;
    }


    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(suburbId);
        attributes.add(nationId);

        return  attributes;
    }
}
