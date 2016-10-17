package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Country;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class AttractionFactory {
<<<<<<< HEAD
    public static Attraction getAttraction(Long id, Country country, AttractionDescription description)
=======
    public static Attraction getAttracion(Long id, Long country, Long description)
>>>>>>> 9d9dd91cf7ed38b317d4378b53ca2dbb4ff9e09d
    {
        return new Attraction.Builder()
                .id(id)
                .country(country)
                .attractionDescription(description)
                .build();
    }


}
