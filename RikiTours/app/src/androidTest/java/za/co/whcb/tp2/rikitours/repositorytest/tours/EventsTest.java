package za.co.whcb.tp2.rikitours.repositorytest.tours;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Events;
import za.co.whcb.tp2.rikitours.domain.tour.EventsDescription;
import za.co.whcb.tp2.rikitours.factories.tour.CityDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CityFactory;
import za.co.whcb.tp2.rikitours.factories.tour.EventDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.EventFactory;
import za.co.whcb.tp2.rikitours.repository.local.tour.EventsRepo;

/**
 * Created by Shaun Mesias on 2016/10/17.
 */
public class EventsTest extends AndroidTestCase {
    private EventsRepo eventsRepo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        eventsRepo = new EventsRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        eventsRepo.close();
        super.tearDown();
    }

    public void addAttractionDescriptionTest() {
        CityDescription cityDescription = CityDescriptionFactory.getCityDescription(1L,"suburb", "nation");
        City city = CityFactory.getCity(1L,"name", cityDescription);

        EventsDescription description = EventDescriptionFactory.getEventDescription(1L,"descrip", "start", "end", city);
        Events events = EventFactory.getEvents(1L, "one", description);
        boolean isAdded = eventsRepo.addEvent(events);
        assertNull(description);
        assertTrue(isAdded);
    }

    public void findAttractionDescriptionById() {
        Events events = eventsRepo.findEventById(1L);
        assertNull(events);
    }
}
