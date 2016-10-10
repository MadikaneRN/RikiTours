package za.co.whcb.tp2.rikitours.config.database.table.tour;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by berka on 10/10/2016.
 */
public class ItenaryTable extends Table {
    public final String tableName = "itenary";
    public static Attribute id = new Attribute("id", "INTEGER");
    public static Attribute groupAttractionId=new Attribute("groupAttractionId","INTEGER");

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

    public Attribute getAttributeGroupAttractionId() {
        return groupAttractionId;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(groupAttractionId);

        return  attributes;
    }
}
