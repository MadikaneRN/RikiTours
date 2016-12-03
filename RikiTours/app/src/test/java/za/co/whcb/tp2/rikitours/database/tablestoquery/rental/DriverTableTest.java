package za.co.whcb.tp2.rikitours.database.tablestoquery.rental;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.rental.DriverTable;

/**
 * Created by berka on 10/16/2016.
 */
public class DriverTableTest {

    @Test
    public void testDriverTable() throws Exception
    {
        DriverTable driverTable = new DriverTable();
        String query = Converter.toCreateTableQuery(driverTable.getTableName(),driverTable.getAllAttributes());
        System.out.println(query);
    }


}
