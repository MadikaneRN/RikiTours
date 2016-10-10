package za.co.whcb.tp2.rikitours.factories.rental;

import za.co.whcb.tp2.rikitours.domain.rental.Rental;

/**
 * Created by work on 10/3/2016.
 */
public class RentalFactory {
    public static Rental getRental(String vehicle, String rentDate, String returnDate, double amountToPay){
        return new Rental.Builder()
                .vehicle(vehicle)
                .rentDate(rentDate)
                .rentDate(returnDate)
                .amountToPay(amountToPay)
                .build();
    }
}
