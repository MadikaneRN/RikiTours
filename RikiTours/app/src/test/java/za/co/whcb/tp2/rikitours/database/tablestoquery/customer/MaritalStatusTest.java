package za.co.whcb.tp2.rikitours.database.tablestoquery.customer;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.customer.MaritalStatusTable;

/**
 * Created by Game330 on 2016-10-10.
 */
public class MaritalStatusTest {
    @Test
    public void testMariatalStatusTable() throws Exception {
        MaritalStatusTable maritalStatusTable = new MaritalStatusTable();
        String query = Converter.toCreateTableQuery(maritalStatusTable.getTableName(),maritalStatusTable.getAllAttributes());
        System.out.println(query);

    }
}
