package za.co.whcb.tp2.rikitours.config.database.table.accommodation;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by lindo on 2016-12-03.
 */
public class RoomTable extends Table {

    private final String tableName = "rooms";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute size = new Attribute("size", "TEXT");
    private final Attribute type = new Attribute("type", "TEXT");
    private final Attribute description = new Attribute("description", "TEXT");
    private final Attribute hotelID = new Attribute("hotelId", "INTEGER");

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

    public Attribute getAttributeSize() {
        return size;
    }

    public Attribute getAttributeType() {
        return type;
    }

    public Attribute getAttributeDescription() {
        return description;
    }

    public Attribute getAttributeHoteID() {
        return hotelID;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(size);
        attributes.add(type);
        attributes.add(description);
        attributes.add(hotelID);

        return  attributes;
    }
}
