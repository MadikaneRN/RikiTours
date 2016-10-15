package za.co.whcb.tp2.rikitours.factories.rental;

import junit.framework.Assert;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.rental.Rental;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;

import static org.junit.Assert.*;

/**
 * Created by Scorpian on 2016-10-04.
 */
public class RentalFactoryTest {

    @Test
    public void testGetRental() throws Exception {

        Vehicle vehicle = VehicleFactory.getVehicle(2,"BMW","M3","2013");

       Assert.assertEquals(vehicle.getVehicleModel(),"M3");



    }
}