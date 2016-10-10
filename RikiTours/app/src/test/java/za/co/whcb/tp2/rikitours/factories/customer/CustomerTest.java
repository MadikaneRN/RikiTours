package za.co.whcb.tp2.rikitours.factories.customer;

import org.junit.Before;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by Game330 on 2016-10-10.
 */
public class CustomerTest {

    private Customer cust;

    @Before
    public void setUp() throws Exception {
        cust=new CustomerFactory().getCustomer("Tam","cotodie","55");
    }


    @Test
    public void testCustomer() throws Exception {
        assertEquals(cust.getName(),"Tam");
        assertEquals(cust.getCustomer_no(),"55");

    }

    @Test
    public void testUpdate() throws Exception {
        Customer upCust=new Customer.Builder().name("thamar").surname("johns").customer_no("89").build();
        assertEquals(upCust.getSurname(),"johns");
        assertEquals(upCust.getCustomer_no(),"89");

    }
}
