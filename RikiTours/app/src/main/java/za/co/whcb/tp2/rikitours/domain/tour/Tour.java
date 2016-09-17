package za.co.whcb.tp2.rikitours.domain.tour;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.guide.Guide;

/**
 * Created by kelly on 9/17/2016.
 */
public class Tour {
    private String id;
    private Guide guide;
    private Customer customer;
    private Itenary itenary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Itenary getItenary() {
        return itenary;
    }

    public void setItenary(Itenary itenary) {
        this.itenary = itenary;
    }
}
