package za.co.whcb.tp2.rikitours.database.tablestoquery.Tour;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.tour.CityTable;

/**
 * Created by work on 10/10/2016.
 */
public class CityTest {
    
    @Test
    public void testCity() throws Exception {

        CityTable attractionTable = new CityTable();
        String query = Converter.toCreateTableQuery(attractionTable.getTableName(),attractionTable.getAllAttributes());
        System.out.println(query);
    }
}
