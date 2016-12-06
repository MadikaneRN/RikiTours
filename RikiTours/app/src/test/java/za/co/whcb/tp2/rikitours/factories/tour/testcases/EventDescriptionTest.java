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

        Country myCountry = CountryFactory.getCountry(2L,"name", "cityDescription","image");
        CityDescription cityDescription = CityDescriptionFactory.getCityDescription(100,"Capital City",myCountry);

        EventsDescription description = EventDescriptionFactory.getEventDescription(123, "descrip","start","end",myCountry);

       Assert.assertNotNull(description);
        Assert.assertEquals("name", description.getCountry().getName());

    }
}
