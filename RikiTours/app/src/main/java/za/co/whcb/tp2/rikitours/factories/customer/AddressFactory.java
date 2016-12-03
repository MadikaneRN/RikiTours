package za.co.whcb.tp2.rikitours.factories.customer;

import za.co.whcb.tp2.rikitours.domain.Address;
import za.co.whcb.tp2.rikitours.domain.tour.City;

/**
 * Created by Game330 on 2016-10-16.
 */
public class AddressFactory {
    public static Address getAddress(Long id, String flatNo, String city, String streetName, String streetNo)
    {
        Address address= new Address.Builder()
                .id(id)
                .city(city)
                .flatNo(flatNo)
                .streetName(streetName)
                .streetNumber(streetNo)
                //.postalCode( postalCode)
                .build();
        return address;

    }
}
