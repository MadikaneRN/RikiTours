package za.co.whcb.tp2.rikitours.rental;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.rental.Rental;
import za.co.whcb.tp2.rikitours.factories.rental.RentalFactory;

/**
 * Created by LILO on 2016/10/10.
 */
public class RentalTest {
    private Rental rental;

    @Before
    public void setUp() throws Exception {
        rental = RentalFactory.getRental("Avanza","6/10/2016","10/10/2016",2500);
    }

    @Test
    public void testRental() throws Exception {
        Assert.assertNotNull(rental);
        Assert.assertEquals(rental.getVehicle(), "Avanza");
    }

    @Test
    public void testRentalUpdate() throws Exception {
        Rental newRental = new Rental.Builder().copy(rental).vehicle("Bus").build();
        Assert.assertEquals("Bus",newRental.getVehicle());
    }
}
