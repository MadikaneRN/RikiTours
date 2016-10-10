package za.co.whcb.tp2.rikitours.config.database.table.car;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by Tamonne on 9/26/2016.
 */
public class CarTable  {

    public final String tableName = "car";
    public static Attribute id = new Attribute("id", "number");
    public static Attribute numberOfSeat = new Attribute("numberOfSeat", "Text");
    public static Attribute year = new Attribute("year", "Text");
    public static Attribute color = new Attribute("color", "Text");


}
