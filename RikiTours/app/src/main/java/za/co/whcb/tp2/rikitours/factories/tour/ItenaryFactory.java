package za.co.whcb.tp2.rikitours.factories.tour;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.tour.Attraction;
import za.co.whcb.tp2.rikitours.domain.tour.Itenary;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class ItenaryFactory {
    public static Itenary getItenary(ArrayList<Attraction> attractions)
    {
        return new Itenary.Builder()
                .attraction(attractions)
                .build();
    }
}
