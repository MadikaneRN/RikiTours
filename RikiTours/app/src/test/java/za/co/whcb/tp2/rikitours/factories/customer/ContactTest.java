package za.co.whcb.tp2.rikitours.factories.customer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.customer.Contact;
import za.co.whcb.tp2.rikitours.domain.customer.CustomerAddress;

/**
 * Created by Game330 on 2016-10-10.
 */
public class ContactTest {

    private Contact contact;


    @Before
    public void setUp()throws Exception {
        contact=ContactFactory.getContact(2L,"0834543345","02145544453");

    }
    @Test

    public void testAddress() throws Exception {
        //Address add=address.AddInt("Claremont","19","415","7708");
        Assert.assertNotNull(contact);
        Assert.assertEquals(contact.getPhoneNo(), "0834543345");
        Assert.assertEquals(contact.getLandlineNo(),"02145544453");

    }

    @Test
    public void testUpdate()throws Exception {

        Contact contact_update;
        contact_update = new Contact.Builder()
                .landlineNo("0713476544")
                .phoneNo("0835676545")
                .build();
        Assert.assertNotNull(contact_update);
        Assert.assertEquals(contact_update.getLandlineNo(), "0713476544");
        Assert.assertEquals(contact_update.getPhoneNo(), "0835676545");
    }
}
