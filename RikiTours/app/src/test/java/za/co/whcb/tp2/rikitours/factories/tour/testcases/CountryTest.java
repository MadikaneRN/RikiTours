package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.domain.tour.String;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CountryTest {
    @Test
    public void testCreate() throws Exception {
        CityDescription cityDescription = CityDescriptionFactory.getCityDescription("suburb", "nation");
        City city = CityFactory.getCity("name", cityDescription);

        String string = CountryDescriptionFactory.getCountryDescription(city, "code", "image");
        Country country = CountryFactory.getCountry("name", string);

        Assert.assertNotNull(country);
        Assert.assertEquals("code", country.getString().getCountryCode());

    }
}
