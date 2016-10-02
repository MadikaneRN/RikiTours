package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;
import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.domain.tour.CountryDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Itenary;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.factories.tour.ItenaryFactory;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class ItenaryTest {
    @Test
    public void testCreate() throws Exception {
        ArrayList<Attraction> attractions = new ArrayList<>();

        CityDescription cityDescription = CityDescriptionFactory.getCityDescription("suburb", "nation");
        City city = CityFactory.getCity("name", cityDescription);

        CountryDescription countryDescription = CountryDescriptionFactory.getCountryDescription(city, "code", "image");
        Country country = CountryFactory.getCountry("name", countryDescription);

        AttractionDescription description = AttractionDescriptionFactory.getAttracionDescription("one", "two", "three", "four");
        Attraction attraction = AttractionFactory.getAttracion(country, description);

        CityDescription cityDescription2 = CityDescriptionFactory.getCityDescription("suburb", "nation");
        City city2 = CityFactory.getCity("name", cityDescription2);

        CountryDescription countryDescription2 = CountryDescriptionFactory.getCountryDescription(city2, "code", "image");
        Country country2 = CountryFactory.getCountry("name", countryDescription);

        AttractionDescription description2 = AttractionDescriptionFactory.getAttracionDescription("shaun", "two", "three", "four");
        Attraction attraction2 = AttractionFactory.getAttracion(country2, description2);

        attractions.add(attraction);
        attractions.add(attraction2);

        Itenary itenary = ItenaryFactory.getItenary(attractions);

        Assert.assertNotNull(itenary);
        Assert.assertEquals("shaun", itenary.getAttractions().get(1).getAttractionDescription().getName());

    }
}
