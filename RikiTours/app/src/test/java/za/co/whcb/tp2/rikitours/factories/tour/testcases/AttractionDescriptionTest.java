package za.co.whcb.tp2.rikitours.factories.tour.testcases;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;
import za.co.whcb.tp2.rikitours.factories.tour.AttractionDescriptionFactory;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class AttractionDescriptionTest {
    @Test
    public void testCreate() throws Exception {
        AttractionDescription attractionDescription = AttractionDescriptionFactory.getAttracionDescription(1L,"Water Front","Cape Town","Sea","waterfront.png");

        Assert.assertNotNull(attractionDescription.getId());
        Assert.assertEquals("Water Front", attractionDescription.getName());

    }
}
