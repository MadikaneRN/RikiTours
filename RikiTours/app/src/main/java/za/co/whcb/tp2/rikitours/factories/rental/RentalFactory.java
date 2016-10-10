package za.co.whcb.tp2.rikitours.factories.rental;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.rental.Rental;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;

/**
 * Created by Scorpian on 2016-10-04.
 */
public class RentalFactory {


    public static Rental getRental(Customer customer, Vehicle vehicle, String status, String rentDate, String returnDate)
    {
        return new Rental.Builder()
                .customer(customer)
                .vehicle(vehicle)
                .status(status)
                .rentDate(rentDate)
                .returnDate(returnDate)
                .build();
    }


}
