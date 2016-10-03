package za.co.whcb.tp2.rikitours.domain.rental;

/**
 * Created by kelly on 10/2/2016.
 */
public class Office {
    private long id;
    private String city;
    private String location;

    public Office(Builder builder){
        this.id = builder.id;
        this.city = builder.city;
        this.location = builder.location;
    }

    public long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getLocation() {
        return location;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static class Builder{
        private long id;
        private String city;
        private String location;

        public Builder id(long id){
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
        public Office build(){return new Office(this);}
    }
}
