package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.domain.tour.CountryDescription;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CountryFactory {
    public static Country getCountry(String name, CountryDescription description)
    {
        return new Country.Builder()
                .name(name)
                .countryDescription(description)
                .build();
    }
}
