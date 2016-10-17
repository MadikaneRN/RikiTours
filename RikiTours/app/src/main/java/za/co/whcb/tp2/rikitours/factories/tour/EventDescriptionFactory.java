package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.tour.City;
import za.co.whcb.tp2.rikitours.domain.tour.Country;
import za.co.whcb.tp2.rikitours.domain.tour.EventsDescription;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class EventDescriptionFactory {
    public static EventsDescription getEventDescription(Long id,String description, String start, String end, Country country)
    {
        return new EventsDescription.Builder()
                .id(id)
                .description(description)
                .start(start)
                .end(end)
                .country(country)
                .build();
    }
}
