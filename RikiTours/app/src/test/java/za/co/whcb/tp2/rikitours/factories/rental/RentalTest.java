package za.co.whcb.tp2.rikitours.factories.rental;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.rental.Rental;
import za.co.whcb.tp2.rikitours.domain.rental.Reservations;
import za.co.whcb.tp2.rikitours.factories.rental.RentalFactory;

/**
 * Created by LILO on 2016/10/10.
 */
public class RentalTest {
    private Rental rental;
    private Reservations reservation;

    @Before
    public void setUp() throws Exception {
        rental = RentalFactory.getRental(12345L, reservation, true);
    }

    @Test
    public void testRental() throws Exception {
        Assert.assertNotNull(rental);
        Assert.assertEquals(rental.getReservation(), reservation);
    }

    @Test
    public void testRentalUpdate() throws Exception {
        Rental newRental = new Rental.Builder().copy(rental).status(false).build();
        Assert.assertEquals(false,newRental.isStatus());
    }
}
