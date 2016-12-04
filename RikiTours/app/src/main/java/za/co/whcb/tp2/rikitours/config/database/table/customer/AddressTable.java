package za.co.whcb.tp2.rikitours.config.database.table.customer;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by Game330 on 2016-10-14.
 */
public class AddressTable extends Table {



    private final String tableName = "contact";
    private final Attribute id = new Attribute("id", "INTEGER");
    private final Attribute flat_no = new Attribute("street_no", "TEXT");
    private final Attribute street_no = new Attribute("street_no", "TEXT");
    private final Attribute suburb = new Attribute("surbub", "TEXT");
    private final Attribute street_name = new Attribute("street_name", "INTEGER");
    private final Attribute house_no = new Attribute("house_no", "INTEGER");
    private final Attribute postalCode = new Attribute("postalCode", "INTEGER");
    private final Attribute city_id = new Attribute("city_id","INTEGER");





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

    public Attribute getAttributeStreetName(){return street_name;}

    public Attribute getAttributeFlat_no() {
        return  flat_no;
    }

    public Attribute getAttributeStreetNo() {
        return  street_no;
    }

    public Attribute getAttributeSurbub() {
        return suburb;
    }

    public Attribute getAttributeHouseNo() {
        return house_no;
    }

    public Attribute getAttributePostalCode() {
        return postalCode;
    }

    public Attribute getAttributeCityId(){return city_id;}



    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(street_no);
        attributes.add(suburb);
        attributes.add(house_no);
        attributes.add(street_name);
        attributes.add(postalCode);
        attributes.add(city_id);

        return  attributes;
    }
}
