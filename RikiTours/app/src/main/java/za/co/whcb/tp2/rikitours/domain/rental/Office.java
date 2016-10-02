package za.co.whcb.tp2.rikitours.domain.rental;

/**
 * Created by kelly on 10/2/2016.
 */
public class Office {
    private String id;
    private String city;
    private String location;

    public Office(Builder builder){
        this.id = builder.id;
        this.city = builder.city;
        this.location = builder.location;
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
    public static class Builder{
        private String id;
        private String city;
        private String location;

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder city(String city){
            this.city = city;
            return this;
        }
        public Builder location(String id){
            this.location = location;
            return this;
        }
        public Builder copy(Office office){
            this.id = office.id;
            this.city = office.city;
            this.location = office.location;

            return this;
        }
    }
}
