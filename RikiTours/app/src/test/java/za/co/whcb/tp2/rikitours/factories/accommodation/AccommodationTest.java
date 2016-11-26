package za.co.whcb.tp2.rikitours.factories.accommodation;

import junit.framework.Assert;
import junit.framework.TestCase;

import za.co.whcb.tp2.rikitours.domain.accommodation.Accommodation;
import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;
import za.co.whcb.tp2.rikitours.domain.accommodation.Room;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.factories.customer.CustomerFactory;

/**
 * Created by berka on 11/26/2016.
 */
public class AccommodationTest extends TestCase {

    public void testGetAccommodation() throws Exception
    {
        Hotel hotel = HotelFactory.getHotel(10,"SunCity","5","Awesome");
        Room room = RoomFactory.getRoom(100,"Double","Luxury",hotel,"Great Experience");
        Customer customer = CustomerFactory.getCustomer(10,"Inno","Mphokeli","1004M");

        Accommodation accommodation = AccommodationFactory
                .getAccommodation(1,customer,room,500.00,"10/12/2016","15/12/2016");

        Assert.assertEquals(500.00,accommodation.getAmountToPay());
        Assert.assertEquals("Inno",accommodation.getCustomer().getName());
        Assert.assertEquals(100,accommodation.getRoom().getId());



    }
}
