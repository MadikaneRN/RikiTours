package za.co.whcb.tp2.rikitours.database.tablestoquery.customer;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.customer.EmergencyContactTable;
import za.co.whcb.tp2.rikitours.domain.customer.EmergencyContact;

/**
 * Created by Tamonne on 2016-10-10.
 */


public class EmergencyContactTest {
    @Test
    public void testEmergencyContactTable() throws Exception {
        EmergencyContactTable emergencyContactTable = new EmergencyContactTable();
        String query = Converter.toCreateTableQuery(emergencyContactTable.getTableName(),emergencyContactTable.getAllAttributes());
        System.out.println(query);

    }
}