
package za.co.whcb.tp2.rikitours.factories.customer;
import za.co.whcb.tp2.rikitours.domain.customer.OccupationDetails;
/**
 * Created by Tamonne on 2016/04/17.
 */
public class EmergencyContactFactory {
    public static OccupationDetails getContact(String custId, String jobType,String companyName,String position)
    {
        OccupationDetails occupationDetails = new OccupationDetails.Builder()
                .customerId(custId)
				.jobType(jobType)
				.companyName(companyName)
				.position(position)
        .build();
        return occupationDetails;

    }
}
