package za.co.whcb.tp2.rikitours.domain.tour;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.tourguide.Guide;
import za.co.whcb.tp2.rikitours.domain.tour.Itenary;

/**
 * Created by Encore on 9/17/2016.
 */
public class Tour {
    private Long id;
    private Guide guide;
    private Customer customer;
    private Itenary itenary;

    public Tour(Builder builder){
        this.id=builder.id;
        this.guide=builder.guide;
        this.customer=builder.customer;
    }

    public Long getId() {
        return id;
    }

    public Guide getGuide() {
        return guide;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Itenary getItenary() {
        return itenary;
    }

    public static class Builder{
        private Long id;
        private Guide guide;
        private Customer customer;
        private Itenary itenary;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder guide(Guide guide) {
            this.guide = guide;
            return this;
        }

        public Builder customer(Customer cudtomer) {
            this.customer = cudtomer;
            return this;
        }

        public Builder itenary(Itenary itenary) {
            this.itenary = itenary;
            return this;
        }

        public Builder copy(Tour tour){
            this.id=tour.id;
            this.guide =tour.guide;
            this.customer = tour.customer;
            this.itenary = tour.itenary;

            return this;
        }
        public Tour build(){
            return new Tour(this);
        }
    }
}
