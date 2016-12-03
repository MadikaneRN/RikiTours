package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.tour.AttractionDescription;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class AttractionDescriptionFactory {
    public static AttractionDescription getAttractionDescription(Long id, String name, String city, String description, String image)
    {
        return new AttractionDescription.Builder()
                .id(id)
                .name(name)
                .city(city)
                .description(description)
                .image(image)
                .build();
    }
}
