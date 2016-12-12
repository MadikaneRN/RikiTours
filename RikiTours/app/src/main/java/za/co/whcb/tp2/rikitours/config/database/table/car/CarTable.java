package za.co.whcb.tp2.rikitours.config.database.table.car;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by Tamonne on 9/26/2016.
 */
public class CarTable extends Table {

    private final String tableName = "car";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute regNumber = new Attribute("reg_number", "TEXT");
    private final Attribute carType = new Attribute("car_type", "TEXT");




    @Override
    public String getTableName() {
        return tableName;
    }

    public Attribute getAttributeId() {
        return id;
    }

    @Override
    public Attribute getPrimaryKey() {
        return id;
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
