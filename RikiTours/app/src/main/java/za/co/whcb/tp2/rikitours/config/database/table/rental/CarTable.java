package za.co.whcb.tp2.rikitours.config.database.table.rental;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by berka on 11/10/2016.
 */
public class CarTable extends Table {

    private final String tableName = "car";
    private final Attribute id = new Attribute("id","INTEGER");
    private final Attribute regNumber = new Attribute("regnumber","INTEGER");
    private final Attribute carType = new Attribute("cartype","INTEGER");

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

    public Attribute getAttributeRegNumber ()
    {
        return regNumber;
    }

    public Attribute getAttributeCarType()
    {
        return carType;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(regNumber);
        attributes.add(carType);

        return  attributes;
    }


}
