package za.co.whcb.tp2.rikitours.domain.rental;

/**
 * Created by kelly on 10/2/2016.
 */
public class Office {
    private String id;
    private String city;
    private String location;

    public Office() {
    }

    public Office(String id, String location, String city) {
        this.id = id;
        this.location = location;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getLocation() {
        return location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
