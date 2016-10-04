package za.co.whcb.tp2.rikitours.factories.rental;

import junit.framework.Assert;
import junit.framework.TestCase;

import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;

/**
 * Created by Scorpian on 2016-10-03.
 */
public class VehicleFactoryTest extends TestCase {

    public void testGetVehicle() throws Exception
    {

        Vehicle vehicle = VehicleFactory.getVehicle("BMW","M3","2013");
        Assert.assertEquals("BMW",vehicle.getVehicleName());

    }
}