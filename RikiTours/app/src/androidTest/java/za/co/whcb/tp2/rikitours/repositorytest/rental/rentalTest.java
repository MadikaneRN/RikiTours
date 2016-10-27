package za.co.whcb.tp2.rikitours.repositorytest.rental;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import za.co.whcb.tp2.rikitours.domain.rental.Rental;
import za.co.whcb.tp2.rikitours.domain.rental.Reservations;
import za.co.whcb.tp2.rikitours.factories.rental.RentalFactory;
import za.co.whcb.tp2.rikitours.repository.local.rental.RentalRepo;

/**
 * Created by berka on 10/27/2016.
 */
public class rentalTest extends AndroidTestCase {

    private RentalRepo rentalRepo;
    private static Reservations reservations;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        rentalRepo = new RentalRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        rentalRepo.close();
        super.tearDown();
    }

    public void addRentalTest() {
        Rental rental = RentalFactory.getRental((long) 16.0, reservations, "rented");
        assertEquals(true, rentalRepo.addRenatl(rental));
    }

    public void findRentalById() {
        Rental rental = rentalRepo.findRentalById((long) 16.0);
        assertEquals("rented", rental.getStatus());

    }
}
