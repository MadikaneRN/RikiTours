package za.co.whcb.tp2.rikitours.database.tablestoquery.accommodation;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.accommodation.HotelTable;

/**
 * Created by berka on 11/26/2016.
 */
public class HotelTabelTest {

    @Test
    public void testHotelTable() throws Exception {

        HotelTable hotelTable = new HotelTable();
        String query = Converter.toCreateTableQuery(hotelTable.getTableName(),hotelTable.getAllAttributes());
        System.out.println(query);

    }
}
