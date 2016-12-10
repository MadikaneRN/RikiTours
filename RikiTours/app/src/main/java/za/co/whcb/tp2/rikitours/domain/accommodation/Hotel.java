package za.co.whcb.tp2.rikitours.domain.accommodation;

/**
 * Created by lindo on 9/17/2016.
 */
public class Hotel{
    private long id;
    private  String  name, star, description;

    public Hotel(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.star = builder.star;
        this.description = builder.description;
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

    public static class Builder {
        private long id;
        private  String  name, star, description;

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder star(String star){
            this.star = star;
            return this;
        }

        public Builder description(String description){
            this.description = description;
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
}
