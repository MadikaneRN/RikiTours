package za.co.whcb.tp2.rikitours.database.tablestoquery.rental;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
<<<<<<< HEAD
import za.co.whcb.tp2.rikitours.config.database.table.rental.CarTable;

/**
 * Created by berka on 11/10/2016.
=======
import za.co.whcb.tp2.rikitours.config.database.table.car.CarTable;

/**
 * Created by berka on 12/12/2016.
>>>>>>> 41e99089259feb00b77256ad1ea3db78ff96b266
 */
public class CarTableTest {

    @Test
<<<<<<< HEAD
    public void testDriveTable() throws Exception
=======
    public void testCarTable() throws Exception
>>>>>>> 41e99089259feb00b77256ad1ea3db78ff96b266
    {
        CarTable carTable = new CarTable();
        String query = Converter.toCreateTableQuery(carTable.getTableName(),carTable.getAllAttributes());
        System.out.println(query);
    }
<<<<<<< HEAD






=======
>>>>>>> 41e99089259feb00b77256ad1ea3db78ff96b266
}
