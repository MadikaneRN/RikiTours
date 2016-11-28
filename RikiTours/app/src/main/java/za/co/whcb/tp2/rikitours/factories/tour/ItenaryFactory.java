package za.co.whcb.tp2.rikitours.factories.tour;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.Itinerary;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class ItenaryFactory {
    public static Itinerary getItenary(Long id, ArrayList<Attraction> attractions)
    {
        return new Itinerary.Builder()
                .id(id)
                .attraction(attractions)
                .build();
    }
}
