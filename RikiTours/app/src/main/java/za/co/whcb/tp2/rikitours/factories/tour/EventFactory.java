package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.gallery.RikiImage;
import za.co.whcb.tp2.rikitours.domain.tour.Events;
import za.co.whcb.tp2.rikitours.domain.tour.EventsDescription;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class EventFactory {
    public static Events getEvents(Long id, String name, EventsDescription description, RikiImage image)
    {
        return new Events.Builder()
                .id(id)
                .name(name)
                .description(description)
                .image(image)
                .build();
    }
}
