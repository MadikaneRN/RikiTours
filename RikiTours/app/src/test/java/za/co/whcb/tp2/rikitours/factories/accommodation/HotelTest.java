package za.co.whcb.tp2.rikitours.factories.accommodation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;

/**
 * Created by lindo on 2016-12-03.
 */
public class HotelTest {
    private Hotel hotel;

    @Before
    public void setUp() throws Exception {
        hotel = HotelFactory.getHotel(1L,"Sun1","5","Self catering");
    }

    @Test
    public void testHotel() throws Exception {
        Assert.assertNotNull(hotel);
        Assert.assertEquals("Sun1", hotel.getName());
    }

    @Test
    public void testHotelUpdate() throws Exception {
        Hotel newHotel  = new Hotel.Builder().copy(hotel).name("Lagoon Hotel") .build();
        Assert.assertEquals("Lagoon Hotel", newHotel.getName());
    }
}

