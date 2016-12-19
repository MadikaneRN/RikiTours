package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.tour.Itinerary;
import za.co.whcb.tp2.rikitours.domain.tour.Tour;
import za.co.whcb.tp2.rikitours.domain.tourguide.Guide;
import za.co.whcb.tp2.rikitours.factories.customer.CustomerFactory;
import za.co.whcb.tp2.rikitours.factories.tour.TourFactory;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class TourTest {
    @Test
    public void testCreate() throws Exception {

        Customer myCust= CustomerFactory.getCustomer(1,"Tam","Cotodie","1345");
        Guide myGuide= new Guide("Nathan","Sleek","1234","ns@mail.com");
        Itinerary itenary=new Itinerary();
        Tour tour= TourFactory.getTour(1L,myGuide,myCust,itenary);
        
        Assert.assertNotNull(tour);
        Assert.assertEquals("Tam",tour.getCustomer().getName());



    }
}
