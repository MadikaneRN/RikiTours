package za.co.whcb.tp2.rikitours.factories.accommodation;

import junit.framework.Assert;
import junit.framework.TestCase;

import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;
import za.co.whcb.tp2.rikitours.domain.accommodation.Room;

/**
 * Created by berka on 11/26/2016.
 */
public class RoomTest extends TestCase {

    public void testGetRoom() throws Exception
    {
        Hotel hotel = HotelFactory.getHotel(10,"SunCity","5","Awesome");

        Room room = RoomFactory.getRoom(100,"Double","Luxury",hotel,"Great Experience");

        Assert.assertEquals("SunCity",room.getHotel().getName());
        Assert.assertEquals("Double",room.getSize());
        Assert.assertEquals(100,room.getId());


    }
}
