package za.co.whcb.tp2.rikitours.factories.rental;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.rental.Reservation;
import za.co.whcb.tp2.rikitours.domain.rental.Vehicle;

/**
 * Created by Lindo on 2016/10/10.
 */
public class ReservationsFactory {
    public static Reservation getReservations(long id, Customer customer, Vehicle vehicle, String pickUpDate, String returnedDate, double amountToPay){
        return new Reservation.Builder()
                .id(id)
                .customer(customer)
                .vehicle(vehicle)
                .pickUpDate(pickUpDate)
                .returnedDate(returnedDate)
                .amountToPay(amountToPay)
                .build();
    }
}
