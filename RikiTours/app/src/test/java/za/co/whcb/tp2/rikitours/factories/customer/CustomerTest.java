package za.co.whcb.tp2.rikitours.factories.customer;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by Tamonne on 11/27/2016.
 */
public class CustomerTest {

    @Test
    public void testCreate() throws Exception {

        Customer customer=CustomerFactory.getCustomer(2,"Tamie","Cotodie","7709");
        Assert.assertNotNull(customer);
        Assert.assertEquals(2,customer.getId());
        Assert.assertEquals("Cotodie",customer.getSurname());



    }

}
