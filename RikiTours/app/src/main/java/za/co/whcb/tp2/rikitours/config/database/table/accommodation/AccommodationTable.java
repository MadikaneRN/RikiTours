package za.co.whcb.tp2.rikitours.config.database.table.accommodation;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by Kishan on 9/26/2016.
 */
public class AccommodationTable extends Table {

    public final String tableName = "accommodation";
    public static Attribute id = new Attribute("id", "NUMBER");
    public static Attribute bookedInDate = new Attribute("bookedInDate", "TEXT");
    public static Attribute bookedOutDate = new Attribute("bookedOutDate", "TEXT");
    public static Attribute customerId = new Attribute("customer", "NUMBER");
    public static Attribute noOfGuests = new Attribute("noOfGuests", "INTEGER");

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

    public Attribute getBookedInDate() {
        return bookedInDate;
    }

    public Attribute getBookedOutDate() {
        return bookedOutDate;
    }

    public Attribute getCustomerId() {
        return customerId;
    }

    public Attribute getNoOfGuests() {
        return noOfGuests;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(bookedInDate);
        attributes.add(bookedOutDate);
        attributes.add(customerId);
        attributes.add(noOfGuests);

        return attributes;


    }
}


















