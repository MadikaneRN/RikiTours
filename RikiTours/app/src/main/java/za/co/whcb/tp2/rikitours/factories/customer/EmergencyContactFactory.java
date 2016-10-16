package za.co.whcb.tp2.rikitours.factories.customer;
import za.co.whcb.tp2.rikitours.domain.customer.EmergencyContact;
/**
 * Created by Tamonne on 2016/04/17.
 */
public class EmergencyContactFactory {
    public static EmergencyContact getContact(String custId, String name,String surname,String relationship,String phone,String landline)
    {
        EmergencyContact emergencyContact = new EmergencyContact.Builder()
        .customerId(custId)
				.name(name)
				.surname(surname)
				.relationship(relationship)
				.phoneNo(phone)
        .landlineNo(landline)
        .build();
        return emergencyContact;

    }
}
