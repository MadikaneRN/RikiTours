package za.co.whcb.tp2.rikitours.database.tablestoquery.customer;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.customer.ContactTable;
/**
 * Created by Game330 on 2016-10-10.
 */
public class ContactTableTest{

    @Test
    public void testCustomerTable() throws Exception{

        ContactTable contactTable = new ContactTable();
        String query = Converter.toCreateTableQuery(contactTable.getTableName(),contactTable.getAllAttributes());
        System.out.println(query);
    }
}
