package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.gallery.RikiImage;
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
        CityDescription cityDescription = CityDescriptionFactory.getCityDescription(1L, "suburb", "nation");
       // City city = CityFactory.getCity("name", cityDescription);
        Country city = CountryFactory.getCountry(2L,"name", "cityDescription","image");

        RikiImage image = new RikiImage("shaun","url");

        EventsDescription description = EventDescriptionFactory.getEventDescription(1L,"descrip", "start", "end", city);
        Events events = EventFactory.getEvents(1L,"name", description, image);

        Assert.assertNotNull(events);
        Assert.assertEquals("name", events.getName());

    }
}
