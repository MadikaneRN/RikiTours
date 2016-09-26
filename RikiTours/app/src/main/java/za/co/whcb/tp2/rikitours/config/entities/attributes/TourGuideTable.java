package za.co.whcb.tp2.rikitours.config.entities.attributes;

/**
 * Created by Tamonne on 9/26/2016.
 */
public class TourGuideTable implements Table {

    public static String tableName = "TourGuide";
    public static Attribute id = new Attribute("id", "number");
    public static Attribute name = new Attribute("name", "Text");
    public static Attribute cell = new Attribute("cell", "Text");
    public static Attribute email = new Attribute("email", "Text");



}
