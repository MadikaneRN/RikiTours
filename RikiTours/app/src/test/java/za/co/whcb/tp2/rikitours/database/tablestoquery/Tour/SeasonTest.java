package za.co.whcb.tp2.rikitours.database.tablestoquery.Tour;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.tour.SeasonTable;

/**
 * Created by Encore on 10/10/2016.
 */
public class SeasonTest {
    @Test
    public void testAttractionDescriptionTable() throws Exception {

        SeasonTable attractionTable = new SeasonTable();
        String query = Converter.toCreateTableQuery(attractionTable.getTableName(),attractionTable.getAllAttributes());
        System.out.println(query);
    }
}
