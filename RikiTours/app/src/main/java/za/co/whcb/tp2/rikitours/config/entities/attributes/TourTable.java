package za.co.whcb.tp2.rikitours.config.entities.attributes;

/**
 * Created by Tamonne on 9/26/2016.
 */
public class TourTable implements Table {


    public static String tableName = "tour";
    public static Attribute id = new Attribute("id", "number");
    public static Attribute customerId = new Attribute("customerId", "number");
    public static Attribute guideId = new Attribute("guideId", "number");
    public static Attribute itenaryId = new Attribute("itenaryId", "number");


}
