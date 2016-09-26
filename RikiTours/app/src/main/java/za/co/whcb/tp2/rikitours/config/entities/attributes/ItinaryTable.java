package za.co.whcb.tp2.rikitours.config.entities.attributes;

/**
 * Created by Tamonne on 9/26/2016.
 */
public class ItinaryTable implements Table {

    public static String tableName = "Itinary";
    public static Attribute id = new Attribute("id", "number");
    public static Attribute attractions = new Attribute("attractions", "Text");



}
