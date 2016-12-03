package za.co.whcb.tp2.rikitours.repositorytest.tour;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.domain.tour.Itinerary;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.CountryFactory;
import za.co.whcb.tp2.rikitours.factories.tour.ItenaryFactory;
import za.co.whcb.tp2.rikitours.repository.local.tour.ItenaryRepo;

/**
 * Created by work on 10/17/2016.
 */
public class ItineraryTest extends AndroidTestCase {
    private ItenaryRepo itenaryRepo ;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        itenaryRepo = new ItenaryRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        itenaryRepo.close();
        super.tearDown();
    }

    public void addEventsDesciptionTest() {
        Country country= CountryFactory.getCountry(2L,"South Africa","Africa","image.jpa");
        AttractionDescription attractionDescription= AttractionDescriptionFactory.getAttractionDescription(2L,"Name","Cape Town","Table Mountain","cape.jpa");
        Attraction attraction=AttractionFactory.getAttraction(2L,country,attractionDescription);
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(attraction);

        Itinerary itinerary = ItenaryFactory.getItenary(2L,attractions);
        assertEquals(true, itenaryRepo.addItenary(itinerary));
    }

    public void findCountryById() {
        Itinerary itinerary = itenaryRepo.findCountryById(2L);
        assertEquals("Conference", itinerary.getId());
    }
}
