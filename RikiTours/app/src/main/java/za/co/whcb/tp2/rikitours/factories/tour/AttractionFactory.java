package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class AttractionFactory {
    public static Attraction getAttracion(Long id, Country country, AttractionDescription description)
    {
        return new Attraction.Builder()
                .id(id)
                .country(country)
                .attractionDescription(description)
                .build();
    }
}
