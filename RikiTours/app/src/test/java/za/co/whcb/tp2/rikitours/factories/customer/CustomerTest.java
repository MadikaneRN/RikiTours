package za.co.whcb.tp2.rikitours.factories.customer;

import org.junit.Before;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.Contacts;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Game330 on 2016-10-10.
 */
public class CustomerTest {

    @Test
    public void testCreate() throws Exception {

        Customer customer = CustomerFactory.getCustomer(2, "Tamie", "Cotodie", "7709");
        Assert.assertNotNull(customer);
        Assert.assertEquals(2, customer.getId());
        Assert.assertEquals("Cotodie", customer.getSurname());


    }
}