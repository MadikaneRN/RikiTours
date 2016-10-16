package za.co.whcb.tp2.rikitours.factories.office;

import za.co.whcb.tp2.rikitours.domain.office.Office;

/**
 * Created by kelly on 10/2/2016.
 */
public class OfficeFactory {
    public static Office getOffice(String city, String location)
    {
        return new Office.Builder()
                .city(city)
                .location(location)
                .build();
    }
}
