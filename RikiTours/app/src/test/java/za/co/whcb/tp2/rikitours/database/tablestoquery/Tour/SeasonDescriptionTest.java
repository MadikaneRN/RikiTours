package za.co.whcb.tp2.rikitours.database.tablestoquery.Tour;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.tour.SeasonDescriptionTable;
import za.co.whcb.tp2.rikitours.domain.tour.SeasonDescription;

/**
 * Created by Encore on 10/10/2016.
 */
public class SeasonDescriptionTest {
    @Test
    public void testAttractionDescriptionTable() throws Exception {

        SeasonDescriptionTable attractionTable = new SeasonDescriptionTable();
        String query = Converter.toCreateTableQuery(attractionTable.getTableName(),attractionTable.getAllAttributes());
        System.out.println(query);
    }
}
