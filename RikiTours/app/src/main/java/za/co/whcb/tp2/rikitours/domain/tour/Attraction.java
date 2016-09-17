package za.co.whcb.tp2.rikitours.domain.tour;

/**
 * Created by kelly on 9/17/2016.
 */
public class Attraction {
    private String id, name, country, city, description, image;

    public Attraction() {
    }

    public Attraction(String id, String name, String country, String city, String description, String image) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.description = description;
        this.image = image;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
