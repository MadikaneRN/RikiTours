package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.domain.tour.CountryDescription;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryDescriptionFactory;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CountryDescriptionTest {
    @Test
    public void testCreate() throws Exception {
        CityDescription cityDescription = CityDescriptionFactory.getCityDescription("suburb", "nation");
        City city = CityFactory.getCity("name", cityDescription);
        CountryDescription countryDescription = CountryDescriptionFactory.getCountryDescription(city, "code", "image");

        Assert.assertNotNull(countryDescription);
        Assert.assertEquals("nation", countryDescription.getCity().getDescription().getNation());

    }
}
