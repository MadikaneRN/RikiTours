package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;
import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;

import za.co.whcb.tp2.rikitours.domain.tour.Itenary;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityFactory;

import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.factories.tour.ItenaryFactory;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class ItenaryTest {
    @Test
    public void testCreate() throws Exception {
        ArrayList<Attraction> attractions = new ArrayList<>();



        Country myCountry = CountryFactory.getCountry(100,"Brazil","dangerous","sa.jpg");
        Country country3 = CountryFactory.getCountry(200,"USA","dangerous","usa.jpg");
        Country country4 = CountryFactory.getCountry(300,"UK","dangerous","uk.jpg");

        CityDescription cityDescription = CityDescriptionFactory.getCityDescription(100,"Capital City",myCountry);
        City city = CityFactory.getCity(10, "name", cityDescription);

        //String string = CountryDescriptionFactory.getCountryDescription(city, "code", "image");


        AttractionDescription description = AttractionDescriptionFactory
                .getAttracionDescription(10,"Table Mountain","Cape","Beauty","table.jpg");
        Attraction attraction = AttractionFactory.getAttracion(1,country4,description);

        CityDescription cityDescription2 = CityDescriptionFactory.getCityDescription(20,"Boring",country3);
        City city2 = CityFactory.getCity(11,"name", cityDescription2);

        //String string2 = CountryDescriptionFactory.getCountryDescription(city2, "code", "image");
        Country country2 = CountryFactory.getCountry(200,"China","dangerous","sa.jpg");

        AttractionDescription description2 = AttractionDescriptionFactory
                .getAttracionDescription(20,"Robben Island","Cape","prison","prison.jpg");

        Attraction attraction2 = AttractionFactory.getAttracion(2,country2, description2);

        attractions.add(attraction);
        attractions.add(attraction2);

        Itenary itenary = ItenaryFactory.getItenary(1,attractions);

        Assert.assertNotNull(itenary);
        Assert.assertEquals("Table Mountain", itenary.getAttractions().get(0).getAttractionDescription().getName());

    }
}
