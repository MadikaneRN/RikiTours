package za.co.whcb.tp2.rikitours.config.database.table.rental;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;


/**
 * Created by berka on 10/10/2016.
 */
public class VehicleTable extends Table{

    private final String tableName = "vehicle";
    private final Attribute id = new Attribute("id","INTEGER");
    private final Attribute vehicleName = new Attribute("vehicle_name","TEXT");
    private final Attribute vehicleModel = new Attribute("vehicle_model","TEXT");
    private final Attribute vehicleYear = new Attribute("vehicle_year","TEXT"); //Should be integer on review of edit code when done





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

    public Attribute getAttributevehicleName() {
        return vehicleName;
    }

    public Attribute getAttributevehicleModel() {
        return vehicleModel;
    }

    public Attribute getAttributevehicleYear() {
        return vehicleYear;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(vehicleName);
        attributes.add(vehicleModel);
        attributes.add(vehicleYear);

        return  attributes;
    }


}
