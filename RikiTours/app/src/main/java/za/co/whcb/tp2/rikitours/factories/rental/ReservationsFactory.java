package za.co.whcb.tp2.rikitours.factories.rental;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.rental.Reservations;

/**
 * Created by LILO on 2016/10/10.
 */
public class ReservationsFactory {
    public static Reservations getReservations(String pickUpDate, String returnedDate, String location, String vehicleType, Customer customer){
        return new Reservations.Builder()
                .pickUpDate(pickUpDate)
                .returnedDate(returnedDate)
                .location(location)
                .vehicleType(vehicleType)
                .customer(customer)
                .build();
    }
}
