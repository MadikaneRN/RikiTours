package za.co.whcb.tp2.rikitours.database.tablestoquery.rental;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.rental.ReservationTable;

/**
 * Created by bishop v on 2016-10-22.
 */
public class ReservationTest {
    @Test
    public void testReservationTable() throws Exception {
        ReservationTable reservationTable = new ReservationTable();
        String query = Converter.toCreateTableQuery(reservationTable.getTableName(),reservationTable.getAllAttributes());
        System.out.println(query);
    }
}
