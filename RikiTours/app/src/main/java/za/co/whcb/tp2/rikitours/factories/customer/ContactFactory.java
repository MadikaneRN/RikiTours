package za.co.whcb.tp2.rikitours.factories.customer;
import za.co.whcb.tp2.rikitours.domain.customer.Contact;
/**
 * Created by Tamonne on 2016/04/17.
 */
public class ContactFactory {
    public static Contact getContact(String phone,String landline)
    {
        Contact contact = new Contact.Builder()
                .phoneNo(phone)
                .landlineNo(landline)
                .build();
        return contact;

    }
}
