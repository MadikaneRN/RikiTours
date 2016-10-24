package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;

import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityFactory;

import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CountryTest {
    @Test
    public void testCreate() throws Exception {
        Country country = CountryFactory.getCountry(1L,"south-africa","South Africa is a country on the southernmost", "sa.jpg");


        Assert.assertNotNull(country.getId());
        Assert.assertEquals("sa.jpg", country.getImage());

    }
}
