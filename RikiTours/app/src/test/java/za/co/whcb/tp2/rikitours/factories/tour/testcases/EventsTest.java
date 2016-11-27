package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.domain.tour.Events;
import za.co.whcb.tp2.rikitours.domain.tour.EventsDescription;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.factories.tour.EventDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.EventFactory;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */

public class EventsTest {
    @Test
    public void testCreate() throws Exception {

        Country myCountry = CountryFactory.getCountry(100,"Brazil","dangerous","sa.jpg");

        CityDescription cityDescription = CityDescriptionFactory.getCityDescription(100,"Capital City",myCountry);

        City city = CityFactory.getCity(1,"name", cityDescription);
        Country country = CountryFactory.getCountry(2,"name", "cityDescription","image");

        EventsDescription description = EventDescriptionFactory.getEventDescription(1, "descrip", "start", "end", country);
        Events events = EventFactory.getEvents(1, "name", description);

        Assert.assertNotNull(events);
        Assert.assertEquals("name", events.getName());

    }
}
