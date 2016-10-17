package za.co.whcb.tp2.rikitours.repositorytest.tour;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import za.co.whcb.tp2.rikitours.domain.tour.SeasonDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Seasons;
import za.co.whcb.tp2.rikitours.factories.tour.SeasonDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.SeasonFactory;
import za.co.whcb.tp2.rikitours.repository.local.tour.SeasonsRepo;

/**
 * Created by work on 10/17/2016.
 */
public class SeasonTest extends AndroidTestCase {
    private SeasonsRepo seasonsRepo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        seasonsRepo = new SeasonsRepo(context);
    }

    @Override
    public void tearDown() throws Exception {
        seasonsRepo.close();
        super.tearDown();
    }

    public void addEventsDesciptionTest() {
        SeasonDescription seasonDescription= SeasonDescriptionFactory.getSeasonsDescription(3L,"Winter",2);

        Seasons seasons= SeasonFactory.getSeasons(4L,"Winter",seasonDescription);
        assertEquals(true, seasonsRepo.addSeason(seasons));
    }

    public void findCountryById() {
        Seasons seasons = seasonsRepo.findCountryById(4L);
        assertEquals("Conference", seasons.getId());
    }
}
