package za.co.whcb.tp2.rikitours.repositorytest.accommodation;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import junit.framework.Assert;

import za.co.whcb.tp2.rikitours.domain.accommodation.Hotel;
import za.co.whcb.tp2.rikitours.factories.accommodation.HotelFactory;
import za.co.whcb.tp2.rikitours.repository.local.accommodation.HotelRepo;

/**
 * Created by berka on 11/26/2016.
 */
public class HotelRepoTest extends AndroidTestCase {

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



    public void addCountryTest() {
        Hotel hotel = HotelFactory.getHotel(10,"SunCity","4","Nice");
        Assert.assertEquals(true,hotelRepo.addHotel(hotel));



    }

        //complete Test Cases to fail and pass
    public void findHotelById() {
        Hotel hotel = hotelRepo.findHotelById(10);
        Assert.assertEquals("SunCity",hotel.getName());

        System.out.println(hotel.getName());
    }


}
