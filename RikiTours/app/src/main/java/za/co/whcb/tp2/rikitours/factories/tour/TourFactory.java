package za.co.whcb.tp2.rikitours.factories.tour;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.tour.Itenary;
import za.co.whcb.tp2.rikitours.domain.tour.Tour;
import za.co.whcb.tp2.rikitours.domain.tourguide.Guide;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class TourFactory {
    public static Tour getTour(Long id,Guide guide, Customer customer, Itenary itenary)
    {
        return new Tour.Builder()
                .id(id)
                .guide(guide)
                .customer(customer)
                .itenary(itenary)
                .build();
    }
}
