package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;
import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;

import za.co.whcb.tp2.rikitours.factories.tour.AttractionDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityFactory;

import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class AttractionTest {
    @Test
    public void testCreate() throws Exception {
       /* CityDescription cityDescription = CityDescriptionFactory.getCityDescription("suburb", "nation");
        City city = CityFactory.getCity("name", cityDescription);

        String string = CountryDescriptionFactory.getCountryDescription(city, "code", "image");
        Country country = CountryFactory.getCountry("name", string);

        AttractionDescription description = AttractionDescriptionFactory.getAttracionDescription("one", "two", "three", "four");
        Attraction attraction = AttractionFactory.getAttracion(country, description);

        Assert.assertNotNull(attraction);
        Assert.assertEquals("image", attraction.getCountry().getString().getFlagImage());*/

    }
}
