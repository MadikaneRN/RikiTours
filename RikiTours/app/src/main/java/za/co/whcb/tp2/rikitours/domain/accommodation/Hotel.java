package za.co.whcb.tp2.rikitours.domain.accommodation;

/**
 * Created by berka on 9/17/2016.
 */
public class Hotel {
    private  String  name, star, description;
    private long id;

    public Hotel() {
    }

    public Hotel(long id, String name, String star, String description) {
        this.id = id;
        this.name = name;
        this.star = star;
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

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
