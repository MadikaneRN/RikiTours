package za.co.whcb.tp2.rikitours.repositorytest.tour;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.domain.tour.EventsDescription;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.factories.tour.EventDescriptionFactory;
import za.co.whcb.tp2.rikitours.repository.local.tour.EventDescriptionRepo;

/**
 * Created by work on 10/17/2016.
 */
public class EventsDescriptionTest extends AndroidTestCase {
    private EventDescriptionRepo eventDescriptionRepo ;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        eventDescriptionRepo = new EventDescriptionRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        eventDescriptionRepo.close();
        super.tearDown();
    }

    public void addEventsDesciptionTest() {
        Country country= CountryFactory.getCountry(2L,"South Africa","Africa","image.jpa");

        EventsDescription eventsDescription= EventDescriptionFactory.getEventDescription(1L,"Conference","12:00 am","05:00 pm",country);
        assertEquals(true, eventDescriptionRepo.addCountry(eventsDescription));
    }

    public void findCountryById() {
        EventsDescription eventsDescription = eventDescriptionRepo.findCountryById(1L);
        assertEquals("Conference", eventsDescription.getDescription());
    }
}
