package za.co.whcb.tp2.rikitours;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import junit.framework.Assert;

import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;
import za.co.whcb.tp2.rikitours.factories.rental.VehicleFactory;
import za.co.whcb.tp2.rikitours.repository.local.rental.VehicleRepo;

/**
 * Created by berka on 10/10/2016.
 */
public class VehicleTest extends AndroidTestCase {

    private VehicleRepo vehicleRepo;


    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        vehicleRepo = new VehicleRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        vehicleRepo.close();
        super.tearDown();
    }


    public void addCountryTest() {
        Vehicle vehicle = VehicleFactory.getVehicle((long) 16.0,"BMW","M3","2016");
        Assert.assertEquals(true,vehicleRepo.addVehicle(vehicle));
    }


    public void findVehicleById() {
        Vehicle vehicle = vehicleRepo.findVehicleById((long)16.0);
        assertEquals("south-africa", vehicle.getVehicleName());
    }


}
