package za.co.whcb.tp2.rikitours.factories.tourGuide;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.tourguide.Guide;

/**
 * Created by gaming on 10/24/2016.
 */
public class TourGuideTest {
    @Test
    public void testCreate() throws Exception {
        Guide guide = TourGuideFactory.getGuide(1L, "Tour", "Tomson", "0736321089", "phindaencore@gmail.com");

        Assert.assertNotNull(guide);
        Assert.assertEquals("Tour", guide.getName());
    }
}
