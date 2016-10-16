package za.co.whcb.tp2.rikitours.factories.rental;

import za.co.whcb.tp2.rikitours.domain.rental.Rental;
import za.co.whcb.tp2.rikitours.domain.rental.Reservations;

/**
 * Created by Lindor on 10/3/2016.
 */
public class RentalFactory {
    public static Rental getRental(Reservations reservation, boolean status){
        return new Rental.Builder()
                .reservation(reservation)
                .status(status)
                .build();
    }
}
