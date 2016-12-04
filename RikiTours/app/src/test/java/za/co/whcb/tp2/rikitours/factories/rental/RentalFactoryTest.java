package za.co.whcb.tp2.rikitours.factories.rental;

import junit.framework.Assert;

import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.rental.Rental;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;
import za.co.whcb.tp2.rikitours.factories.customer.CustomerFactory;

import static org.junit.Assert.*;

/**
 * Created by Scorpian on 2016-10-04.
 */
public class RentalFactoryTest {

    @Test
    public void testGetRental() throws Exception {

        Vehicle vehicle = VehicleFactory.getVehicle(0,"BMW","M3","2013");
        Customer customer = CustomerFactory.getCustomer(0,"Berka","ayowa","082333312");

        //Rental rental = RentalFactory.getRental(customer,vehicle,"rented","12/12/2016","01/27/2017");

        //Assert.assertEquals(rental.getCustomer().getName(),"Berka");



    }
}