package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CityDescriptionTest {
    @Test
    public void testCreate() throws Exception {

        CityDescription cityDescription = CityDescriptionFactory.getCityDescription(12345L,"suburb", "nation");

        Assert.assertNotNull(cityDescription);
        Assert.assertEquals("nation", cityDescription.getNation());

    }
}
