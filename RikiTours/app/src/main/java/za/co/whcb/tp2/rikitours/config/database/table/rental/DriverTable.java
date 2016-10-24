package za.co.whcb.tp2.rikitours.config.database.table.rental;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by berka on 10/16/2016.
 */
public class DriverTable extends Table {

    private final String tableName = "driver";
    private final Attribute id = new Attribute("id","INTEGER");
    private final Attribute fname = new Attribute("f_name","TEXT");
    private final Attribute active = new Attribute("active","TEXT"); //should boolean
    private final Attribute driverId = new Attribute("driverId","TEXT");


    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(fname);
        attributes.add(active);
        attributes.add(driverId);
        return  attributes;
    }

    public Attribute getAttributeId() {
        return id;
    }

    @Override
    public Attribute getPrimaryKey()
    {
        return id;
    }

    public Attribute getAttributeFname() {
        return fname;
    }

    public Attribute getAttributeActive() {
        return active;
    }

    public Attribute getAttributeDriverId()
    {
        return driverId;
    }



}
