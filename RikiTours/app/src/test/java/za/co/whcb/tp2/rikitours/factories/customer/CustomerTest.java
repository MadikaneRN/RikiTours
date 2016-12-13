package za.co.whcb.tp2.rikitours.factories.customer;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.Contacts;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by Tamonne on 11/27/2016.
 */
public class CustomerTest {

//    private Customer cust;
//
//    Contacts contacts = new Contacts(1L,"0833455647", "workNumber","address","sdfds")
//
//    @Before
//    public void setUp() throws Exception {
//        cust = CustomerFactory.getCustomer()
//                .getOffice("Cape Town","Gardens");
//    }
//
//    @Test
//    public void testOffice() throws Exception {
//        Assert.assertNotNull(office);
//        Assert.assertEquals("Cape Town", office.getCity());
//    }
//
//    @Test
//    public void testOfficeUpdate() throws Exception {
//        Office newOffice  = new Office.Builder().copy(office).city("Durban") .build();
//        Assert.assertEquals("Durban", newOffice.getCity());
//    }

    @Test
    public void testCreate() throws Exception {

        Customer customer=CustomerFactory.getCustomer(2,"Tamie","Cotodie","7709");
        Assert.assertNotNull(customer);
        Assert.assertEquals(2,customer.getId());
        Assert.assertEquals("Cotodie",customer.getSurname());



    }


}
