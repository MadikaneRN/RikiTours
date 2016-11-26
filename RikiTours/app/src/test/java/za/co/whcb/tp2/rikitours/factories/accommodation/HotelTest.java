package za.co.whcb.tp2.rikitours.factories.accommodation;

import junit.framework.Assert;
import junit.framework.TestCase;

import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;

/**
 * Created by berka on 11/26/2016.
 */
public class HotelTest extends TestCase {

    public void testGetHotel() throws Exception
    {
        Hotel hotel = HotelFactory.getHotel(10,"SunCity","5","Awesome");
        Assert.assertEquals("SunCity",hotel.getName());
        Assert.assertEquals(10,hotel.getId());



    }
}
