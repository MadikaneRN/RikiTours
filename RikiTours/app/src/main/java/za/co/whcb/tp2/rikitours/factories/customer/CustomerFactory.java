package za.co.whcb.tp2.rikitours.factories.customer;

import za.co.whcb.tp2.rikitours.domain.Address;
import za.co.whcb.tp2.rikitours.domain.Contacts;
import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by Game330 on 2016-10-10.
 */


public class CustomerFactory {

  public static Customer getCustomer(long id, String name, String surname, String customer_no, Contacts contacDetails)
    {
        Customer customer = new Customer.Builder()
                .contactDetails(contacDetails)
                .id(id)
                .name(name)
                .surname(surname)
                .build();
        return customer;

    }
}

