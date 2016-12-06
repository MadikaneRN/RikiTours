package za.co.whcb.tp2.rikitours.database.tablestoquery.Tour;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.tour.AttractionDescriptionTable;

/**
 * Created by work on 10/10/2016.
 */
public class AttractionDescriptionTest {
    
    @Test
    public void testAttractionDescriptionTable() throws Exception {

        AttractionDescriptionTable attractionTable = new AttractionDescriptionTable();
        String query = Converter.toCreateTableQuery(attractionTable.getTableName(),attractionTable.getAllAttributes());
        System.out.println(query);
    }
}
