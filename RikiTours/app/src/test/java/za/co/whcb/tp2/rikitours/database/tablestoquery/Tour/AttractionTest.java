package za.co.whcb.tp2.rikitours.database.tablestoquery.Tour;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.tour.AttractionTable;

/**
 * Created by work on 10/10/2016.
 */
public class AttractionTest {
    
    @Test
    public void testAttractionTable() throws Exception {

        AttractionTable attractionTable = new AttractionTable();
        String query = Converter.toCreateTableQuery(attractionTable.getTableName(),attractionTable.getAllAttributes());
        System.out.println(query);
    }
}
