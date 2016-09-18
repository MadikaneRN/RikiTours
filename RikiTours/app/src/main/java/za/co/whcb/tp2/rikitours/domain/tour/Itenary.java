package za.co.whcb.tp2.rikitours.domain.tour;

import java.util.ArrayList;

/**
 * Created by kelly on 9/17/2016.
 */
public class Itenary {
    private String id;
    private ArrayList<Attraction> attractions;

    public Itenary() {
    }

    public Itenary(String id, ArrayList<Attraction> attractions) {
        this.id = id;
        this.attractions = attractions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public void AddAttraction(Attraction attraction) {
        this.attractions.add(attraction);
    }
}
