package za.co.whcb.tp2.rikitours.database.tablestoquery.customer;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.customer.OccupationalDetailsTable;

/**
 * Created by Game330 on 2016-10-10.
 */
public class OccupationalDetailsTableTest {

    @Test
    public void testOccupationalDetailsTable() throws Exception {

        OccupationalDetailsTable occupationalDetails= new OccupationalDetailsTable();
        String query = Converter.toCreateTableQuery(occupationalDetails.getTableName(),occupationalDetails.getAllAttributes());
        System.out.println(query);

    }
}
