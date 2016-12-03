package za.co.whcb.tp2.rikitours.config.database.table.tour;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by Encore on 9/26/2016.
 */
public class TourTable  extends Table{


    public final String tableName = "tour";
    public static Attribute id = new Attribute("id", "INTEGER");
    public static Attribute customerId = new Attribute("customerId", "INTEGER");
    public static Attribute guideId = new Attribute("guideId", "INTEGER");
    public static Attribute itenaryId = new Attribute("itenaryId", "INTEGER");

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

    public Attribute getAttributeCustomerId() {
        return customerId;
    }

    public Attribute getAttributeGuideId() {
        return guideId;
    }

    public Attribute getAttributeItenryId() {
        return itenaryId;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(customerId);
        attributes.add(guideId);
        attributes.add(itenaryId);

        return  attributes;
    }

}
