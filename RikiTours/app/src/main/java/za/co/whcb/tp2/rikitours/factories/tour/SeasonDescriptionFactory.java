package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.tour.SeasonDescription;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class SeasonDescriptionFactory {
    public static SeasonDescription getSeasonsDescription(Long id,String description, int number)
    {
        return new SeasonDescription.Builder()
                .id(id)
                .description(description)
                .number(number)
                .build();
    }
}
