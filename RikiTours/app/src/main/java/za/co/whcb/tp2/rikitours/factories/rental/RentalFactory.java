package za.co.whcb.tp2.rikitours.factories.rental;

import za.co.whcb.tp2.rikitours.domain.rental.Rental;
import za.co.whcb.tp2.rikitours.domain.rental.Reservations;

/**
 * Created by Lindo on 10/3/2016.
 */
public class RentalFactory {
    public static Rental getRental(long id, Reservations reservation, boolean status){
        return new Rental.Builder()
                .id(id)
                .reservation(reservation)
                .status(status)
                .build();
    }
}
