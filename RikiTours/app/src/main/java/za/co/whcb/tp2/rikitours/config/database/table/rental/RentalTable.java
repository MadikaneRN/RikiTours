package za.co.whcb.tp2.rikitours.config.database.table.rental;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by Lindo on 10/17/2016.
 */
public class RentalTable extends Table{

    private final String tableName = "countries";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute reservationID = new Attribute("reservationId", "INTEGER");
    private final Attribute status = new Attribute("status", "TEXT");

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

    public Attribute getReservationID() {
        return reservationID;
    }

    public Attribute getStatus() {
        return status;
    }

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(reservationID);
        attributes.add(status);

        return  attributes;
    }
}
