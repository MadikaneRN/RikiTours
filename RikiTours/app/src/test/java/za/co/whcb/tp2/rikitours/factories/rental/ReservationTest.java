package za.co.whcb.tp2.rikitours.factories.rental;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.rental.Reservation;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;

/**
 * Created by LILO on 2016/10/10.
 */
public class ReservationTest {

    private Reservation reservation;
    private Customer customer;
    private Vehicle vehicle;

    @Before
    public void setUp() throws Exception {

        reservation = ReservationsFactory.getReservations(12345L,customer,vehicle,"10/10/2016","15/10/2016",2500);
    }

    @Test
    public void testReservations() throws Exception {

        Assert.assertNotNull(reservation);
        Assert.assertEquals(reservation.getCustomer(),customer);
    }

    @Test
    public void testReservationsUpdate() throws Exception {
        
        Reservation newReservation = new Reservation.Builder().copy(reservation).pickUpDate("09/10/2016").build();
        Assert.assertEquals("09/10/2016", newReservation.getPickUpDate());
    }
}
