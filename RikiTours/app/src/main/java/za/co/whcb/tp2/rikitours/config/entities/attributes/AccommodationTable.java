package za.co.whcb.tp2.rikitours.config.entities.attributes;

/**
 * Created by Tamonne on 9/26/2016.
 */
public class AccommodationTable implements Table {

    // private Room room;
    //  private Customer customer;

    public static String tableName = "accommodation";
    public static Attribute id = new Attribute("id", "number");
    public static Attribute bookedInDate = new Attribute("bookedInDate", "Text");
    public static Attribute bookedOutDate = new Attribute("bookedOutDate", "Text");
    public static Attribute amountToPay = new Attribute("amountToPay", "number");
    public static Attribute customerId = new Attribute("customerId", "number");
    public static Attribute roomId = new Attribute("roomId", "number");

}


