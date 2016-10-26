package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityFactory;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CityTest {
    @Test
    public void testCreate() throws Exception {
        CityDescription cityDescription = CityDescriptionFactory.getCityDescription(1L, "suburb", "nation");
        City city = CityFactory.getCity(1L, "name", cityDescription);

        Assert.assertNotNull(city);
        Assert.assertEquals("suburb", city.getDescription().getSuburb());

    }
}
