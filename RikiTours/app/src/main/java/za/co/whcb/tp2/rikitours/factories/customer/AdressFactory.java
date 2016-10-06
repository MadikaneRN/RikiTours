package za.co.whcb.tp2.rikitours.factories.customer;

import za.co.whcb.tp2.rikitours.domain.customer.CustomerAddress;

/**
 * Created by Game330 on 2016-10-06.
 */
public class AdressFactory {

    public static CustomerAddress getAddress(String suburb, String street_no, String house_no, String postalCode)
    {
        CustomerAddress address= new CustomerAddress.Builder()
                .suburb(suburb)
                .street_no(street_no)
                .house_no(house_no)
                .postalCode( postalCode)
                .build();
        return address;

    }
}
