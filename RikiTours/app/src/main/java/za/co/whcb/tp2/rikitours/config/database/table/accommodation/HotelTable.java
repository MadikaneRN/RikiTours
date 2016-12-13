package za.co.whcb.tp2.rikitours.config.database.table.accommodation;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by berka on 11/26/2016.
 */
public class HotelTable  extends Table {

    private final String tableName = "hotel";
    public static Attribute id = new Attribute("id", "INTEGER");
    public static Attribute name = new Attribute("name","TEXT");
    public static Attribute star = new Attribute("star","TEXT");
    public static Attribute description = new Attribute("description","TEXT");


    public  Attribute getName() {
        return name;
    }

    public  Attribute getStar() {
        return star;
    }

    public  Attribute getDescription() {
        return description;
    }


    public Attribute getAttributeId() {
        return id;
    }

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public Attribute getPrimaryKey() {
        return id;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(name);
        attributes.add(star);
        attributes.add(description);

        return attributes;
    }


}
