package za.co.whcb.tp2.rikitours.config.entities.attributes;

/**
 * Created by Tamonne on 9/26/2016.
 */
public class HotelTable implements Table {


    public static String tableName = "hotel";
    public static Attribute id = new Attribute("id", "number");
    public static Attribute name = new Attribute("name", "Text");
    public static Attribute star = new Attribute("star", "Text");
    public static Attribute description = new Attribute("description", "Text");


}
