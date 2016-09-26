package za.co.whcb.tp2.rikitours.config.database.table.itinerary;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;

/**
 * Created by Tamonne on 9/26/2016.
 */
public class ItineraryTable implements Table {

    public final String tableName = "itinerary";
    public static Attribute id = new Attribute("id", "number");
    public static Attribute attractions = new Attribute("attractions", "Text");

    @Override
    public String getName() {
        return null;
    }
}
