package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CityFactory {
    public static City getCity(String name, CityDescription description)
    {
        return new City.Builder()
                .name(name)
                .description(description)
                .build();
    }
}
