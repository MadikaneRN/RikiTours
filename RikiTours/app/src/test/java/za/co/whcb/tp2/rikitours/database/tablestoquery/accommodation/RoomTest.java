package za.co.whcb.tp2.rikitours.database.tablestoquery.accommodation;


import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.accommodation.RoomTable;

/**
 * Created by lindo on 2016-12-03.
 */
public class RoomTest {
    @Test
    public void testRoomTable() throws Exception {
        RoomTable roomTable = new RoomTable();
        String query = Converter.toCreateTableQuery(roomTable.getTableName(),roomTable.getAllAttributes());
        System.out.println(query);

    }
}
