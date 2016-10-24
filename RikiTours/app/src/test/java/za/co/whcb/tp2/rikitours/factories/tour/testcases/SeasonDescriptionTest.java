package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.tour.SeasonDescription;
import za.co.whcb.tp2.rikitours.factories.tour.SeasonDescriptionFactory;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class SeasonDescriptionTest {
    @Test
    public void testCreate() throws Exception {
        SeasonDescription description = SeasonDescriptionFactory.getSeasonsDescription(1L,"Nice Season", 4);

        Assert.assertNotNull(description);
        Assert.assertEquals(4, description.getNumberOfSeason());

    }
}
