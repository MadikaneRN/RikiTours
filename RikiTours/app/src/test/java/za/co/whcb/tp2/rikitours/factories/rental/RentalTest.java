package za.co.whcb.tp2.rikitours.factories.rental;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.rental.Rental;
import za.co.whcb.tp2.rikitours.domain.rental.Reservation;

/**
 * Created by LILO on 2016/10/10.
 */
public class RentalTest {

    private Rental rental;
    private Reservation reservation;

    @Before
    public void setUp() throws Exception {

        rental = RentalFactory.getRental(12345L, reservation, "rented");
    }

    @Test
    public void testRental() throws Exception {
        
        Assert.assertNotNull(rental);
        Assert.assertEquals(rental.getReservation(), reservation);
    }

    @Test
    public void testRentalUpdate() throws Exception {
        Rental newRental = new Rental.Builder().copy(rental).status("cancelled").build();
        Assert.assertEquals("cancelled",newRental.getStatus());
    }
}
