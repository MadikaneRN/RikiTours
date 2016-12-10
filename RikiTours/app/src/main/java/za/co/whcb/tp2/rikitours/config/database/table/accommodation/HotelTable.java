package za.co.whcb.tp2.rikitours.config.database.table.accommodation;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by lindo on 2016-12-03.
 */
public class HotelTable extends Table{

    private final String tableName = "hotels";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute name = new Attribute("hotel_name", "TEXT");
    private final Attribute star = new Attribute("star", "TEXT");
    private final Attribute description = new Attribute("description", "TEXT");

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

    public Attribute getAttributeStar() {
        return star;
    }

    public Attribute getAttributeDescription() {
        return description;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(name);
        attributes.add(star);
        attributes.add(description);

        return  attributes;
    }
}
