package za.co.whcb.tp2.rikitours.database.tablestoquery.rental;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.rental.RentalTable;

/**
 * Created by Lindo on 10/10/2016.
 */
public class RentalTest {

    @Test
    public void testRentalTable() throws Exception {
        RentalTable rentalTable = new RentalTable();
        String query = Converter.toCreateTableQuery(rentalTable.getTableName(),rentalTable.getAllAttributes());
        System.out.println(query);

    }
}
