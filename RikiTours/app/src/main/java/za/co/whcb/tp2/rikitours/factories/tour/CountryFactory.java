package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.tour.Country;


/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CountryFactory {
    public static Country getCountry(long id, String name, String description, String image)
    {
        return new Country.Builder()
                .id(id)
                .name(name)
                .description(description)
                .image(image)
                .build();
    }
}
