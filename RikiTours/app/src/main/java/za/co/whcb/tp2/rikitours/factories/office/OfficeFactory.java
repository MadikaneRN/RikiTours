package za.co.whcb.tp2.rikitours.factories.office;

import za.co.whcb.tp2.rikitours.domain.office.Office;

/**
 * Created by Lindo on 10/2/2016.
 */
public class OfficeFactory {
    public static Office getOffice(long id, String city, String location)
    {
        return new Office.Builder()
                .id(id)
                .city(city)
                .location(location)
                .build();
    }
}
