package za.co.whcb.tp2.rikitours.database.tablestoquery.rental;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.common.Converter;
import za.co.whcb.tp2.rikitours.config.database.table.rental.VehicleTable;

/**
 * Created by berka on 10/10/2016.
 */
public class RentalTest {

    @Test
    public void testCountryTable() throws Exception {
        VehicleTable vehicleTable = new VehicleTable();
        String query = Converter.toCreateTableQuery(vehicleTable.getTableName(),vehicleTable.getAllAttributes());
        System.out.println(query);

    }
}
