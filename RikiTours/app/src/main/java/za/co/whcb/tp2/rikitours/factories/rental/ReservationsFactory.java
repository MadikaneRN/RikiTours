package za.co.whcb.tp2.rikitours.factories.rental;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.rental.Reservations;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;

/**
 * Created by LILO on 2016/10/10.
 */
public class ReservationsFactory {
    public static Reservations getReservations(long id, Customer customer, Vehicle vehicle, String pickUpDate, String returnedDate, double amountToPay){
        return new Reservations.Builder()
                .id(id)
                .customer(customer)
                .vehicle(vehicle)
                .pickUpDate(pickUpDate)
                .returnedDate(returnedDate)
                .amountToPay(amountToPay)
                .build();
    }
}
