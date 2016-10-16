package za.co.whcb.tp2.rikitours.factories.customer;
import za.co.whcb.tp2.rikitours.domain.customer.MaritalStatus;
/**
 * Created by Tamonne on 2016/04/17.
 */
public class MaritalStatusFactory {
    public static MaritalStatus getContact(String custId, String single,String married,String divorced)
    {
        MaritalStatus maritalStatus = new MaritalStatus.Builder()
                .customerId(custId)
				.single(single)
				.married(married)
				.divorced(divorced)
        .build();
        return maritalStatus;

    }
}
