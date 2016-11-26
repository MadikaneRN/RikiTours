package za.co.whcb.tp2.rikitours.domain.accommodation;

/**
 * Created by berka on 9/17/2016.
 */
public class Hotel {
    private long id;
    private  String name, star, description;

    public Hotel() {
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getStar(){return star;}


    public static class Builder {
        private long id;
        private  String name, star, description;

        public Builder id(long id) {
            this.id = id;
            return this;
        }
        public Builder name(String value) {
            this.name = value;
            return this;
        }
        public Builder star(String value){
            this.star = value;
            return this;
        }

        public Builder description(String value){
            this.description = value;
            return this;
        }


        public Builder copy(Hotel hotel){
            this.id = hotel.id;
            this.name = hotel.name;
            this.star = hotel.star;
            this.description = hotel.description;
            return this;
        }
        public Hotel build(){return new Hotel(this);}
    }

    public Hotel(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.star = builder.star;
    }


}
