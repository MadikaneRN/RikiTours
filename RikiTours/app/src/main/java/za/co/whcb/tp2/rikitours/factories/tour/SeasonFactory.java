package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.tour.SeasonDescription;
import za.co.whcb.tp2.rikitours.domain.tour.Seasons;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class SeasonFactory {
    public static Seasons getSeasons(String name, SeasonDescription description)
    {
        return new Seasons.Builder()
                .name(name)
                .description(description)
                .build();
    }
}
