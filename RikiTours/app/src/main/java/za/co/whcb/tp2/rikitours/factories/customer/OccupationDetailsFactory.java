package za.co.whcb.tp2.rikitours.factories.customer;

import za.co.whcb.tp2.rikitours.domain.customer.OccupationalDetails;

/**
 * Created by Game330 on 2016-10-16.
 */
public class OccupationDetailsFactory {
    public static OccupationalDetails getContact(String custId, String jobType, String companyName, String position)
    {
        OccupationalDetails occupationDetails = new OccupationalDetails.Builder()
                .customerId(custId)
                .jobType(jobType)
                .companyName(companyName)
                .position(position)
                .build();
        return occupationDetails;

    }
}
