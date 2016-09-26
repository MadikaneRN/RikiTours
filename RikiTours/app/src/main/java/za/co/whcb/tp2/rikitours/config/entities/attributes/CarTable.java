package za.co.whcb.tp2.rikitours.config.entities.attributes;

/**
 * Created by Tamonne on 9/26/2016.
 */
public class CarTable implements Table {


    public static String tableName = "car";
    public static Attribute id = new Attribute("id", "number");
    public static Attribute numberOfSeat = new Attribute("numberOfSeat", "Text");
    public static Attribute year = new Attribute("year", "Text");
    public static Attribute color = new Attribute("color", "Text");



}
