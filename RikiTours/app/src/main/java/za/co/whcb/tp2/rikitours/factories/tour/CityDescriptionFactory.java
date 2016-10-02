package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.tour.CityDescription;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CityDescriptionFactory {
    public static CityDescription getCityDescription(String suburb, String nation)
    {
        return new CityDescription.Builder()
                .suburb(suburb)
                .nation(nation)
                .build();
    }
}
