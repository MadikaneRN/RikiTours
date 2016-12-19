package za.co.whcb.tp2.rikitours.factories.customer;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.customer.OccupationalDetails;

/**
 * Created by Tamonne on 12/19/2016.
 */
public class OccupationalDetailsTest {
    @Test
    public void testCreate() throws Exception {
        OccupationalDetails occupationalDetails= OccupationDetailsFactory.getContact("2","Clerk","KC","Admin");
        Assert.assertNotNull(occupationalDetails);
        Assert.assertEquals("2",occupationalDetails.getCustomerId());
        Assert.assertEquals("KC",occupationalDetails.getCompanyName());





    }



}
