package za.co.whcb.tp2.rikitours.repositorytest.rental;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.rental.Reservations;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;
import za.co.whcb.tp2.rikitours.factories.rental.ReservationsFactory;
import za.co.whcb.tp2.rikitours.repository.local.rental.ReservationRepo;

/**
 * Created by Lindo on 2016-10-22.
 */
public class ReservationTest extends AndroidTestCase {
    
    private ReservationRepo reservationRepo;
    private static Customer customer;
    private static Vehicle vehicle;

    @Override
    public void setUp() throws Exception {

        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        reservationRepo = new ReservationRepo(context);
    }

    @Override
    public void tearDown() throws Exception {

        reservationRepo.close();
        super.tearDown();
    }

    public void addReservationTest() {

        Reservations reservations = ReservationsFactory.getReservations((long) 16.0,customer, vehicle, "10/10/2016","16/10/2016",2000);
        assertEquals(true, reservationRepo.addReservation(reservations));
    }

    public void findResrvationById() {

        Reservations reservations = reservationRepo.findReservationById((long)16.0);
        assertEquals("10/10/2016", reservations.getPickUpDate());
    }
}
