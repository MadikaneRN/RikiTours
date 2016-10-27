package za.co.whcb.tp2.rikitours.factories.customer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.customer.EmergencyContact;

/**
 * Created by Game330 on 2016-10-10.
 */
public class EmergencyContactTest {
    private EmergencyContact emergecyContact;

    @Before
    public void setUp() throws Exception {
        emergecyContact= new EmergencyContactFactory().getContact("122", "Innocent","Mphokeli", "somerelationship", "0844323875","0713456465");
    }


    @Test
    public void testCustomer() throws Exception {
        Assert.assertEquals(emergecyContact.getName(),"Innocent");
        Assert.assertEquals(emergecyContact.getLandlineNo(),"0713456465");

    }

    @Test
    public void testUpdate() throws Exception {
        EmergencyContact emergecyContact = new EmergencyContact.Builder().name("thamar").surname("johns").landlineNo("0713456465").build();
        Assert.assertEquals(emergecyContact.getSurname(),"johns");
        Assert.assertEquals(emergecyContact.getLandlineNo(),"0713456465");

    }
}
