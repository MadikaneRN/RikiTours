package za.co.whcb.tp2.rikitours.domain.tour;

import java.util.ArrayList;

/**
 * Created by Encore on 9/17/2016.
 */
public class Itinerary {
    private Long id;
    private ArrayList<Attraction> attractions;

    public Itinerary() {
    }

    public Itinerary(Builder builder) {
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
        private Long id;
        private ArrayList<Attraction> attractions;
        public Builder id(Long id){
            this.id=id;
            return this;
        }
        public Builder attraction(ArrayList<Attraction> attractions){
            this.attractions = attractions;
            return this;
        }
        public Builder copy(Itinerary itinerary){
            this.id= itinerary.id;
            this.attractions = itinerary.attractions;

            return this;
        }
        public Itinerary build(){
            return new Itinerary(this);
        }
    }
}
