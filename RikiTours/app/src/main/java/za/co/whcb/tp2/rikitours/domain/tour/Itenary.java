package za.co.whcb.tp2.rikitours.domain.tour;

import java.util.ArrayList;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;

/**
 * Created by Encore on 9/17/2016.
 */
public class Itenary {
    private Long id;
    private ArrayList<Attraction> attractions;

    public Itenary() {
    }

    public Itenary(Builder builder) {
        this.id = builder.id;
        this.attractions = builder.attractions;
    }

    public Long getId() {
        return id;
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public void AddAttraction(Attraction attraction) {
        this.attractions.add(attraction);
    }
    public static class Builder{
        Long id;
        ArrayList<Attraction> attractions;
        public Builder id(Long id){
            this.id=id;
            return this;
        }
        public Builder attraction(Attraction attractions){
            this.attractions = attractions;
            return this;
        }
        public Builder copy(Itenary itenary){
            this.id=itenary.id;
            this.attractions = itenary.attractions;

            return this;
        }
        public Itenary build(){
            return new Itenary(this);
        }
    }
}
