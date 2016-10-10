package za.co.whcb.tp2.rikitours.config.database.table.customer;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by Tamonne on 9/26/2016.
 */
public class CustomerTable  {


    private final String tableName = "customer";
    public static Attribute id = new Attribute("id", "number");
    public static Attribute name = new Attribute("name", "Text");
    public static Attribute surname = new Attribute("surname", "Text");



}
