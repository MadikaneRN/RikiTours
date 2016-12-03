package za.co.whcb.tp2.rikitours.domain;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;

/**
 * Created by berka on 10/15/2016.
 */
public class VehicleDomainTest {

    @Test
    public void testVehicleCreation()
    {
        Vehicle vehicle = new Vehicle.Builder()
                .id(2l)
                .vehicleYear("1991")
                .vehicleModel("Focus")
                .vehicleName("Ford")
                .build();


        Assert.assertNotNull(vehicle);
        Assert.assertEquals(vehicle.getId(),2l);
        Assert.assertEquals(vehicle.getVehicleName(),"Ford");
        Assert.assertEquals("1991",vehicle.getVehicleYear());
        Assert.assertEquals("Focus",vehicle.getVehicleModel());



    }


}
