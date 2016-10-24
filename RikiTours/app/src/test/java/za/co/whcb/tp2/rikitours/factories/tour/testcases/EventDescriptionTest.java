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
        Country country = CountryFactory.getCountry(2L,"name", "cityDescription","image");
        EventsDescription eventsDescription = EventDescriptionFactory.getEventDescription(3L,"Jazz Festival","08:00 am","08:00 pm",country);

        Assert.assertNotNull(eventsDescription);
        Assert.assertEquals("08:00 pm", eventsDescription.getEnd());

    }
}
