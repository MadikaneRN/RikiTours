package za.co.whcb.tp2.rikitours.repositorytest.accommodation;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;
import za.co.whcb.tp2.rikitours.factories.accommodation.HotelFactory;
import za.co.whcb.tp2.rikitours.repository.local.accommodation.HotelRepo;

/**
 * Created by bishop v on 2016-12-06.
 */
public class HotelTest extends AndroidTestCase {
    private HotelRepo hotelRepo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        hotelRepo = new HotelRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        hotelRepo.close();
        super.tearDown();
    }

    public void addHotelTest() {
        Hotel hotel = HotelFactory.getHotel(1L,"Sun1","5","self catering");
        assertEquals(true, hotelRepo.addHotel(hotel));
    }

    public void findCountryById() {
        Hotel hotel = hotelRepo.findHotelById(1);
        assertEquals("Sun1", hotel.getName());
    }
}
