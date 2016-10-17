package za.co.whcb.tp2.rikitours.config.database.table.rental;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by Lindo on 10/17/2016.
 */
public class ReservationTable extends Table{

    private final String tableName = "reservation";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute customerID = new Attribute("customerID", "INTEGER");
    private final Attribute vehicleID = new Attribute("vehicleID", "INTEGER");
    private final Attribute pickUpDate = new Attribute("pickUpDate", "TEXT");
    private final Attribute returnDate = new Attribute("returnDate", "TEXT");
    private final Attribute amountToPay = new Attribute("amountToPay", "TEXT");

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

    public Attribute getCustomerID() {
        return customerID;
    }

    public Attribute getVehicleID() {
        return vehicleID;
    }

    public Attribute getPickUpDate() {
        return pickUpDate;
    }

    public Attribute getReturnDate() {
        return returnDate;
    }

    public Attribute getAmountToPay() {
        return amountToPay;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(customerID);
        attributes.add(vehicleID);
        attributes.add(pickUpDate);
        attributes.add(returnDate);
        attributes.add(amountToPay);

        return  attributes;
    }
}
