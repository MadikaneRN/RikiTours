package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CityDescriptionFactory {
    public static CityDescription getCityDescription(long id,String description, Country country)
    {
        return new CityDescription.Builder()
                .id(id)
                .description(description)
                .country(country)
                .build();
    }
}
