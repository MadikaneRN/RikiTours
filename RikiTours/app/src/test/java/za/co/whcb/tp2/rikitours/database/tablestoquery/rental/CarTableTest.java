package za.co.whcb.tp2.rikitours.database.tablestoquery.rental;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.car.CarTable;

/**
 * Created by berka on 12/12/2016.
 */
public class CarTableTest {

    @Test
    public void testCarTable() throws Exception
    {
        CarTable carTable = new CarTable();
        String query = Converter.toCreateTableQuery(carTable.getTableName(),carTable.getAllAttributes());
        System.out.println(query);
    }
}
