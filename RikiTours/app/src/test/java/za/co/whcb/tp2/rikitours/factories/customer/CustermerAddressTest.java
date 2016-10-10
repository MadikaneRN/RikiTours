package za.co.whcb.tp2.rikitours.factories.customer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.customer.CustomerAddress;

/**
 * Created by Game330 on 2016-10-10.
 */
public class CustermerAddressTest {

    private CustomerAddress address;


    @Before
    public void setUp()throws Exception {
        address=AddressFactory.getAddress("Claremont","19","415","7708");

    }
    @Test

    public void testAddress() throws Exception {
        //Address add=address.AddInt("Claremont","19","415","7708");
        Assert.assertNotNull(address);
        Assert.assertEquals(address.getHouse_no(), "415");
        Assert.assertEquals(address.getPostalCode(),"7708");
        Assert.assertEquals(address.getSuburb(),"Claremont");

    }

    @Test
    public void testUpdate()throws Exception{

        CustomerAddress  address_update;
        address_update = new CustomerAddress.Builder()
                .postalCode("7790")
                .house_no("780")
                .street_no("12")
                .build();
        Assert.assertNotNull(address_update);
        Assert.assertEquals(address_update.getPostalCode(),"7790");
        Assert.assertEquals(address_update.getStreet_no(),"12");


    }
}
