package za.co.whcb.tp2.rikitours.config.database.table.customer;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by Tamonne on 10/10/2016.
 */
public class EmergencyContactTable extends Table{



    private final String tableName = "emergencyContact";

    private final Attribute id = new Attribute("id", "INTEGER");

    private final Attribute name = new Attribute("name", "TEXT");
    private final Attribute surname = new Attribute("surname", "TEXT");
    private final Attribute relationship = new Attribute("relationship", "TEXT");

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

    public Attribute getAttributeName() {
        return name;
    }
    public Attribute getAttributeSurname() {
        return surname;
    }
    public Attribute getAttributeRelationship() {
        return  relationship;
    }

    public Attribute getAttributePhoneNo() {
        return  phoneNo;
    }

    public Attribute getAttributeLandllieNo() {
        return landLineNo;
    }

    public Attribute getAttributeCustomerId() {
        return customerId;
    }



    @Override
    protected ArrayList<Attribute> getAllAttributes() {


        ArrayList<Attribute> attributes = new ArrayList<>();

        attributes.add(id);
        attributes.add(name);
        attributes.add(surname);

        attributes.add(relationship);
        attributes.add(phoneNo);
        attributes.add(landLineNo);
        attributes.add(customerId);

        return attributes;
    }
}




































