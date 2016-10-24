package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;
import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;

import za.co.whcb.tp2.rikitours.domain.tour.Itenary;
import za.co.whcb.tp2.rikitours.domain.tour.Tour;
import za.co.whcb.tp2.rikitours.domain.tourguide.Guide;
import za.co.whcb.tp2.rikitours.factories.customer.CustomerFactory;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityFactory;

import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.factories.tour.ItenaryFactory;
import za.co.whcb.tp2.rikitours.factories.tour.TourFactory;
import za.co.whcb.tp2.rikitours.factories.tourGuide.TourGuideFactory;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class ItenaryTest {
    @Test
    public void testCreate() throws Exception {
        Country country= CountryFactory.getCountry(1L,"South Africa","Africa","SA.png");
        AttractionDescription attractionDescription= AttractionDescriptionFactory.getAttracionDescription(1L,"Description","Cape Town","Table Mountain","table.png");
        Attraction attraction= AttractionFactory.getAttracion(1L,country,attractionDescription);
        ArrayList<Attraction> attractionArrayList=new ArrayList<>();
        attractionArrayList.add(attraction);
        Guide guide= TourGuideFactory.getGuide(1L,"Tour","Tomson","0736321089","phindaencore@gmail.com");
        Customer customer= CustomerFactory.getCustomer(2L,"Likhona","Tosmon","214162966");
        Itenary itenary= ItenaryFactory.getItenary(3L,attractionArrayList);

        Assert.assertNotNull(itenary);
        Assert.assertTrue(itenary.getAttractions().size()>0);
    }
}
