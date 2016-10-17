package za.co.whcb.tp2.rikitours.factories.tour;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.Itenary;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class ItenaryFactory {
    public static Itenary getItenary(Long id,ArrayList<Attraction> attractions)
    {
        return new Itenary.Builder()
                .id(id)
                .attraction(attractions)
                .build();
    }
}
