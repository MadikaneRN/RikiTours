package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.domain.tour.String;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CountryFactory {
    public static Country getCountry(long id, java.lang.String name, String description)
    {
        return new Country.Builder()
                .id(id)
                .name(name)
                .countryDescription(description)
                .build();
    }
}
