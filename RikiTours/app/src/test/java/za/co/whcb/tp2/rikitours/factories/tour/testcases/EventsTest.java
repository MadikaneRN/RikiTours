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
        Country country= CountryFactory.getCountry(1L,"South Africa","Africa","SA.png");
        EventsDescription eventsDescription=EventDescriptionFactory.getEventDescription(1L,"Fashion","08:00 am","08:00 pm",country);
        Events events=EventFactory.getEvents(1L,"Durban July",eventsDescription);

        Assert.assertNotNull(events);
        Assert.assertEquals("08:00 pm", events.getDescription().getEnd());
    }
}
