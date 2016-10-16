package za.co.whcb.tp2.rikitours.rental;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.rental.Reservations;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;
import za.co.whcb.tp2.rikitours.factories.rental.ReservationsFactory;

/**
 * Created by LILO on 2016/10/10.
 */
public class ReservationsTest {
    private Reservations reservations;
    private Customer customer;
    private Vehicle vehicle;

    @Before
    public void setUp() throws Exception {
        reservations = ReservationsFactory.getReservations(customer,vehicle,"10/10/2016","15/10/2016",2500);
    }

    @Test
    public void testReservations() throws Exception {
        Assert.assertNotNull(reservations);
        Assert.assertEquals(reservations.getCustomer(),customer);
    }

    @Test
    public void testReservationsUpdate() throws Exception {
        Reservations newReservations = new Reservations.Builder().copy(reservations).pickUpDate("09/10/2016").build();
        Assert.assertEquals("09/10/2016", newReservations.getPickUpDate());
    }
}
