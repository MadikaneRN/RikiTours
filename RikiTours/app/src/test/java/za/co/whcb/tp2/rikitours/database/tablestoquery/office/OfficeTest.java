package za.co.whcb.tp2.rikitours.database.tablestoquery.office;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.office.OfficeTable;

/**
 * Created by Lindo on 10/16/2016.
 */
public class OfficeTest {
    @Test
    public void testOfficeTable() throws Exception {
        OfficeTable officeTable = new OfficeTable();
        String query = Converter.toCreateTableQuery(officeTable.getTableName(),officeTable.getAllAttributes());
        System.out.println(query);

    }
}
