package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.String;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CountryDescriptionFactory {
    public static String getCountryDescription(City city, java.lang.String code, java.lang.String image)
    {
        return new String.Builder()
                .city(city)
                .countryCode(code)
                .flagImage(image)
                .build();
    }
}
