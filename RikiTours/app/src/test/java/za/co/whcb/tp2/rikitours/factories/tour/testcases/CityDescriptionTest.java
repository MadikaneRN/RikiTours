package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CityDescriptionTest {
    @Test
    public void testCreate() throws Exception {
        Country myCountry = CountryFactory.getCountry(100,"Brazil","dangerous","sa.jpg");

        CityDescription cityDescription = CityDescriptionFactory.getCityDescription(100,"Capital City",myCountry);

        Assert.assertNotNull(cityDescription);
        Assert.assertEquals(cityDescription.getCountry().getName(),"Brazil");
        Assert.assertEquals(cityDescription.getCountry().getImage(),"sa.jpg");

    }
}
