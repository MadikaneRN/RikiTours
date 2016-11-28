package za.co.whcb.tp2.rikitours.domain.tour;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;
import za.co.whcb.tp2.rikitours.domain.tourguide.Guide;

/**
 * Created by Encore on 9/17/2016.
 */
public class Tour {
    private Long id;
    private Guide guide;
    private Customer customer;
    private Itinerary itinerary;

    public Tour(Builder builder){
        this.id=builder.id;
        this.guide=builder.guide;
        this.customer=builder.customer;
        this.itinerary =builder.itinerary;
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

    public Itinerary getItinerary() {
        return itinerary;
    }

    public static class Builder{
        private Long id;
        private Guide guide;
        private Customer customer;
        private Itinerary itinerary;

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

        public Builder itenary(Itinerary itinerary) {
            this.itinerary = itinerary;
            return this;
        }

        public Builder copy(Tour tour){
            this.id=tour.id;
            this.guide =tour.guide;
            this.customer = tour.customer;
            this.itinerary = tour.itinerary;

            return this;
        }
        public Tour build(){
            return new Tour(this);
        }
    }
}
