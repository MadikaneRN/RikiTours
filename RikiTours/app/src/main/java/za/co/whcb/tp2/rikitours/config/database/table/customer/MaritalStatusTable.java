package za.co.whcb.tp2.rikitours.config.database.table.customer;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by Tamonne on 10/10/2016.
 */
public class MaritalStatusTable extends Table {


    private final String tableName = "maritalStatus";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute single = new Attribute("single", "TEXT");
    private final Attribute married = new Attribute("married", "TEXT");
    private final Attribute divorced = new Attribute("divorced", "TEXT");
    private final Attribute customerId = new Attribute("customerId", "INTEGER");



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

    public Attribute getAttributeSingle() {
        return  single;
    }

    public Attribute getAttributeMarried() {
        return married;
    }

    public Attribute getAttributeDivorced() {
        return  divorced;
}

    public Attribute getAttributeCustomerId() {
        return customerId;
    }



    @Override
   public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(single);
        attributes.add(married);
        attributes.add(divorced);
        attributes.add(customerId);
        return attributes;
    }





}
