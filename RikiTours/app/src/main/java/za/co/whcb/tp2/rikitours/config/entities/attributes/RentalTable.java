package za.co.whcb.tp2.rikitours.config.entities.attributes;

/**
 * Created by Tamonne on 9/26/2016.
 */
public class RentalTable implements Table {


    public static String tableName = "rental";
    public static Attribute id = new Attribute("id", "number");
    public static Attribute car = new Attribute("car", "Text");
    public static Attribute rentDate = new Attribute("rentDate", "Text");


}
