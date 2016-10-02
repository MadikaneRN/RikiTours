package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.CountryDescription;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CountryDescriptionFactory {
    public static CountryDescription getCountryDescription(City city, String code, String image)
    {
        return new CountryDescription.Builder()
                .city(city)
                .countryCode(code)
                .flagImage(image)
                .build();
    }
}
