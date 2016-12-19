package za.co.whcb.tp2.rikitours.factories.customer;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.customer.MaritalStatus;

/**
 * Created by Tamonne on 12/19/2016.
 */
public class MaritalStatusTest {
    @Test
    public void testCreate() throws Exception {

        MaritalStatus maritalStatus= MaritalStatusFactory.getMaritalStatus("2","yes","No");
        Assert.assertNotNull(maritalStatus);
        Assert.assertEquals("2",maritalStatus.getCustomerId());
        Assert.assertEquals("yes",maritalStatus.getIsSingle());



    }

}
