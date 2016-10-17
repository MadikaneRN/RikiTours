package za.co.whcb.tp2.rikitours.config.database.table.attraction;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by Tamonne on 9/26/2016.
 */
public class AttractionTable  {

    public final String tableName = "attractions";
    public static Attribute id = new Attribute("id", "number");
    public static Attribute city = new Attribute("city", "Text");
    public static Attribute description = new Attribute("description", "Text");
    public static Attribute image = new Attribute("image", "Text");


}
