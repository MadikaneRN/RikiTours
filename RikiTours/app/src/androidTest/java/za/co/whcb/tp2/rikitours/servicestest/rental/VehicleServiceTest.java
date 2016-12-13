package za.co.whcb.tp2.rikitours.servicestest.rental;

import android.content.Context;
import android.content.Intent;
import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import junit.framework.Assert;

import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;
import za.co.whcb.tp2.rikitours.factories.rental.VehicleFactory;
import za.co.whcb.tp2.rikitours.repository.local.rental.VehicleRepo;
import za.co.whcb.tp2.rikitours.services.domain.rental.VehicleService;

/**
 * Created by berka on 12/12/2016.
 */
public class VehicleServiceTest extends AndroidTestCase {

    private VehicleService vehicleService;
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


    public void testAdd() {
        Vehicle vehicle = VehicleFactory.getVehicle((long) 16.0,"BMW","M3","2016");
        Assert.assertEquals(true,vehicleRepo.addVehicle(vehicle));
    }






}
