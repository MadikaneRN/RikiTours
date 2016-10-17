package za.co.whcb.tp2.rikitours.factories.customer;

import za.co.whcb.tp2.rikitours.domain.customer.CustomerAddress;

/**
 * Created by Game330 on 2016-10-06.
 */
public class AddressFactory {

    public static CustomerAddress getAddress(Long id, String suburb, String street_no, String house_no, String postalCode)
    {
        CustomerAddress address= new CustomerAddress.Builder()
                .id(id)
                .suburb(suburb)
                .street_no(street_no)
                .house_no(house_no)
                .postalCode( postalCode)
                .build();
        return address;

    }
}
