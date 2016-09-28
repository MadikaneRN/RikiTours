package za.co.whcb.tp2.rikitours.domain.tour;

import za.co.whcb.tp2.rikitours.domain.tour.Country;
/**
 * Created by kelly on 9/17/2016.
 */
public class Attraction {
    private Long id, String name,Country country,String city,String description,String image;

    public Attraction() {
    }

    public Attraction(Builder builder) {
        this.name = builder.name;
        this.country = builder.country;
        this.city = builder.city;
        this.description = builder.description;
        this.image = builder.image;
        this.id = builder.id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public static class Builder{
        Long id, String name,Country country,String description,String image;
        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder name(String name){
            this.name=name;
            return this;
        }

        public Builder country(Country country){
            this.country=country;
            return this;
        }

        public Builder description(String description){
            this.description=description;
            return this;
        }

        public Builder image(String image){
            this.image=image;
            return this;
        }

        public Builder copy(Attraction attraction){
            this.id=attraction.id;
            this.name=attraction.name;
            this.country=attraction.country;
            this.description=attraction.description;
            this.image=attraction.image;

            return this;
        }
        public Attraction build(){
            return new Attraction(this);


        }
}
