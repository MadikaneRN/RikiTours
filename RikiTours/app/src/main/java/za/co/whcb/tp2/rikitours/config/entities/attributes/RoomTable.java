package za.co.whcb.tp2.rikitours.config.entities.attributes;

/**
 * Created by Tamonne on 9/26/2016.
 */
public class RoomTable implements Table {


    public static String tableName = "room";
    public static Attribute id = new Attribute("id", "number");
    public static Attribute size = new Attribute("size", "Text");
    public static Attribute type = new Attribute("type", "Text");
    public static Attribute description = new Attribute("description", "Text");
    public static Attribute hotelId = new Attribute("hotelId", "Text");


}
