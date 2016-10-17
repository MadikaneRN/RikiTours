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
        AttractionDescription description = AttractionDescriptionFactory.getAttracionDescription(12345L, "one", "two", "three", "four");

        Assert.assertNotNull(description);
        Assert.assertEquals("three", description.getDescription());

    }
}
