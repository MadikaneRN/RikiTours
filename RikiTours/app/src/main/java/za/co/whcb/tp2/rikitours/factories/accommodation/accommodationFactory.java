package za.co.whcb.tp2.rikitours.factories.accommodation;

import za.co.whcb.tp2.rikitours.domain.accommodation.Accommodation;
import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;
import za.co.whcb.tp2.rikitours.domain.accommodation.Room;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by berka on 11/26/2016.
 */
public class AccommodationFactory {

    private long id;
    private Room room;
    private Customer customer;
    private String bookedInDate;
    private String bookedOutDate;
    private double amountToPay;


    public static Accommodation getAccommodation(long id, Customer customer, Room room, double amountToPay, String bookedInDate, String bookedOutDate)
    {
        return new Accommodation.Builder()
                .id(id)
                .customer(customer)
                .room(room)
                .amountToPay(amountToPay)
                .bookedInDate(bookedInDate)
                .bookedOutDate(bookedOutDate)
                .build();
    }


}
