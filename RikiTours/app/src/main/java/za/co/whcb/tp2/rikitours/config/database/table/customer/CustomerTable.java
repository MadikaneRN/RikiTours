package za.co.whcb.tp2.rikitours.config.database.table.customer;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by Tamonne on 9/26/2016.
 */
public class CustomerTable extends Table {


    private final String tableName = "customer";
    public static Attribute id = new Attribute("id", "number");
    public static Attribute name = new Attribute("name", "Text");
    public static Attribute surname = new Attribute("surname", "Text");



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
        return  name;
    }

    public Attribute getAttributeSurname() {
        return surname;
    }


     @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(name);
        attributes.add(surname);
        return  attributes;
    }

}
