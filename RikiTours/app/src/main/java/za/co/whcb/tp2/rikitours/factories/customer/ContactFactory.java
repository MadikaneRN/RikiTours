package za.co.whcb.tp2.rikitours.factories.customer;

import za.co.whcb.tp2.rikitours.domain.Address;
import za.co.whcb.tp2.rikitours.domain.Contacts;

/**
 * Created by Game330 on 2016-10-16.
 */
public class ContactFactory {
    public static Contacts getContact(long id, String cellNo, String workNu, Address address)
    {
          Contacts contacts = new Contacts.Builder()
            .id(id)
            .cellNumber(cellNo)
            .workNo(workNu)
            .address(address)
            .build();
        return contacts;

    }
}
