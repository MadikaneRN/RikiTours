package za.co.whcb.tp2.rikitours.database.tablestoquery.rental;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.rental.CarTable;

/**
 * Created by berka on 11/10/2016.
 */
public class CarTableTest {

    @Test
    public void testDriveTable() throws Exception
    {
        CarTable carTable = new CarTable();
        String query = Converter.toCreateTableQuery(carTable.getTableName(),carTable.getAllAttributes());
        System.out.println(query);
    }






}
