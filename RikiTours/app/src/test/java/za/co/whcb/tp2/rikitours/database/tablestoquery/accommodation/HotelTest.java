package za.co.whcb.tp2.rikitours.database.tablestoquery.accommodation;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.accommodation.HotelTable;

/**
 * Created by lindo on 2016-12-03.
 */
public class HotelTest {
    @Test
    public void testHotelTable() throws Exception {
        HotelTable hotelTable = new HotelTable();
        String query = Converter.toCreateTableQuery(hotelTable.getTableName(),hotelTable.getAllAttributes());
        System.out.println(query);

    }
}
