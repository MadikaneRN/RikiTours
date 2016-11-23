package za.co.whcb.tp2.rikitours.domain.accommodation;

import java.io.Serializable;

/**
 * Created by berka on 9/17/2016.
 */
public class Hotel implements Serializable {
    private  String  name, description;
    private int star;
    private long id;
    private String city;

    public Hotel() {
    }

    public Hotel(long id, String name,String city, int star, String description) {
        this.id = id;
        this.name = name;
        this.star = star;
        this.city =city;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
