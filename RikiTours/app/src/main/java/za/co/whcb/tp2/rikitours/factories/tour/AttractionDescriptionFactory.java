package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class AttractionDescriptionFactory {
    public static AttractionDescription getAttracionDescription(long id,String name,String city,String descrip, String image)
    {
        return new AttractionDescription.Builder()
                .id(id)
                .name(name)
                .city(city)
                .description(descrip)
                .image(image)
                .build();
    }
}
