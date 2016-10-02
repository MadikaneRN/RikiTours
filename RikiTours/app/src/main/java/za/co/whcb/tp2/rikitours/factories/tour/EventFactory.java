package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.tour.Events;
import za.co.whcb.tp2.rikitours.domain.tour.EventsDescription;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class EventFactory {
    public static Events getEvents(String name, EventsDescription description)
    {
        return new Events.Builder()
                .name(name)
                .description(description)
                .build();
    }
}
