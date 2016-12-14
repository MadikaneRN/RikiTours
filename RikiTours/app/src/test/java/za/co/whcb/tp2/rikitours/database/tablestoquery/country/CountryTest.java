package za.co.whcb.tp2.rikitours.database.tablestoquery.country;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.common.CountryTable;

/**
 * Created by work on 10/8/2016.
 */
public class CountryTest {

    @Test
    public void testCountryTable() throws Exception {

        CountryTable countryTable = new CountryTable();
        String query = Converter.toCreateTableQuery(countryTable.getTableName(),countryTable.getAllAttributes());
        System.out.println(query);

    }
}
