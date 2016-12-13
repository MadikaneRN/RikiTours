package za.co.whcb.tp2.rikitours.repositorytest.tour;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import za.co.whcb.tp2.rikitours.domain.tour.SeasonDescription;
import za.co.whcb.tp2.rikitours.factories.tour.SeasonDescriptionFactory;
import za.co.whcb.tp2.rikitours.repository.local.tour.SeasonDescriptionRepo;

/**
 * Created by work on 10/17/2016.
 */
public class SeasonDescriptionTest extends AndroidTestCase {

    private SeasonDescriptionRepo seasonDescriptionRepo;

    @Override
    public void setUp() throws Exception {

        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        seasonDescriptionRepo = new SeasonDescriptionRepo(context);
    }

    @Override
    public void tearDown() throws Exception {

        seasonDescriptionRepo.close();
        super.tearDown();
    }

    public void addEventsDesciptionTest() {

        SeasonDescription seasonDescription= SeasonDescriptionFactory.getSeasonsDescription(3L,"Winter",2);
        assertEquals(true, seasonDescriptionRepo.addSeasonDescription(seasonDescription));
    }

    public void findCountryById() {

        SeasonDescription seasonDescription = seasonDescriptionRepo.findCountryById(3L);
        assertEquals("Conference", seasonDescription.getId());
    }
}
