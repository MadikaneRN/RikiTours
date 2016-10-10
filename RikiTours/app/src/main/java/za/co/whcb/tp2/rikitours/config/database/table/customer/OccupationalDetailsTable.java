package za.co.whcb.tp2.rikitours.config.database.table.customer;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by Tamonne on 10/10/2016.
 */
public class OccupationalDetailsTable extends Table {


    private final String tableName = "occupationalDetails";
    private final Attribute id = new Attribute("id", "INTEGER");

    private final Attribute position = new Attribute("position", "TEXT");
    private final Attribute jobType = new Attribute("jobType", "TEXT");
    private final Attribute companyName = new Attribute("companyName", "TEXT");
    private final Attribute customerId = new Attribute("customerId", "INTEGER");



    @Override
    protected String getTableName() {
        return tableName;
    }

    @Override
    protected Attribute getPrimaryKey() {
        return id;
    }


    public Attribute getAttributeId() {
        return id;
    }

    public Attribute getAttributeJobType() {
        return  jobType;
    }

    public Attribute getAttributePosition() {
        return position;
    }

    public Attribute getAttributeCompanyName() {
        return companyName;
    }

    public Attribute getAttributeCustomerId() {
        return customerId;
    }



    @Override
    protected ArrayList<Attribute> getAllAttributes() {
        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(jobType);
        attributes.add(position);
        attributes.add(companyName);
        attributes.add(customerId);

        return  attributes;
    }
}
