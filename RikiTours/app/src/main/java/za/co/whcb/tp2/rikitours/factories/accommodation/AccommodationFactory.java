package za.co.whcb.tp2.rikitours.factories.accommodation;

import za.co.whcb.tp2.rikitours.domain.accommodation.Accommodation;
import za.co.whcb.tp2.rikitours.domain.accommodation.Room;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by berka on 12/12/2016.
 */
public class AccommodationFactory {

    private Room room;
    private Customer customer;
    private String bookedInDate;
    private String bookedOutDate;
    private double amountToPay;

    public static Accommodation
    getAccommodation(long id,Room room,Customer customer,String bookedOutDate,String bookedInDate,double amountToPay)
    {
        return new Accommodation.Builder()
                .id(id)
                .Customer(customer)
                .Room(room)
                .bookedInDate(bookedInDate)
                .bookedOutDate(bookedOutDate)
                .build();
    }
}
