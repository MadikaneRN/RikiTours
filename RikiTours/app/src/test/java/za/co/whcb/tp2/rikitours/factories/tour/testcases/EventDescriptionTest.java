package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.domain.tour.EventsDescription;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.factories.tour.EventDescriptionFactory;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class EventDescriptionTest {
    @Test
    public void testCreate() throws Exception {
        CityDescription cityDescription = CityDescriptionFactory.getCityDescription(12345L, "suburb", "nation");
        Country city = CountryFactory.getCountry(2L,"name", "cityDescription","image");

        EventsDescription description = EventDescriptionFactory.getEventDescription(12345L, "descrip","start","end",city);

        Assert.assertNotNull(description);
        Assert.assertEquals("descrip", description.getDescription());

    }
}
