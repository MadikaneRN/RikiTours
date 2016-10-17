package za.co.whcb.tp2.rikitours.config.database.table.customer;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by Tamonne on 10/10/2016.
 */
public class EmergencyContactTable extends Table{



    private final String tableName = "emergencyContact";

    public final Attribute id = new Attribute("id", "INTEGER");

    public final Attribute name = new Attribute("name", "TEXT");
    public final Attribute surname = new Attribute("surname", "TEXT");
    public final Attribute relationship = new Attribute("relationship", "TEXT");

    public final Attribute phoneNo = new Attribute("phoneNo", "TEXT");
    public final Attribute landLineNo = new Attribute("landlineLineNo", "TEXT");
    public final Attribute customerId = new Attribute("customerId", "INTEGER");



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
    public ArrayList<Attribute> getAllAttributes() {


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




































