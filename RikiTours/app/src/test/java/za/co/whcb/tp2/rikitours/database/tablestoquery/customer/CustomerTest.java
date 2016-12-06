package za.co.whcb.tp2.rikitours.database.tablestoquery.customer;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.customer.CustomerTable;

/**
 * Created by Game330 on 2016-10-10.
 */
public class CustomerTest {

    @Test
    public void testCustomerTable() throws Exception {
        
        CustomerTable customerTable = new CustomerTable();
        String query = Converter.toCreateTableQuery(customerTable.getTableName(),customerTable.getAllAttributes());
        System.out.println(query);

    }

}
