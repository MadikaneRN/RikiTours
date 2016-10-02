package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.tour.SeasonDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Seasons;
import za.co.whcb.tp2.rikitours.factories.tour.SeasonDescriptionFactory;
import za.co.whcb.tp2.rikitours.factories.tour.SeasonFactory;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class SeasonTest {
    @Test
    public void testCreate() throws Exception {
        SeasonDescription description = SeasonDescriptionFactory.getSeasonsDescription("descrip", 4);
        Seasons seasons = SeasonFactory.getSeasons("summer", description);

        Assert.assertNotNull(seasons);
        Assert.assertEquals(4, seasons.getDescription().getNumberOfSeason());

    }
}
