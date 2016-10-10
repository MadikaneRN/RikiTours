package za.co.whcb.tp2.rikitours.config.database.table.customer;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by Tamonne on 10/10/2016.
 */
public class ContactTable extends Table{

    private final String tableName = "contact";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute phoneNo = new Attribute("phoneNo", "TEXT");
    private final Attribute landLineNo = new Attribute("landlineLineNo", "TEXT");
    private final Attribute customerId = new Attribute("customerId", "INTEGER");




    @Override
    protected String getTableName() {
        return tableName;
    }
    @Override
    protected Attribute getPrimaryKey() {
            return id;
    }


    public Attribute getAttributeId() {
        return id;
    }

    public Attribute getAttributePhoneNo() {
        return  phoneNo;
    }

    public Attribute getAttributeLandlineNo() {
        return landLineNo;
    }

    public Attribute getAttributeCustomerId() {
        return customerId;
    }




    @Override
    protected ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(phoneNo);
        attributes.add(landLineNo);
        attributes.add(customerId);

        return  attributes;
    }
}






























