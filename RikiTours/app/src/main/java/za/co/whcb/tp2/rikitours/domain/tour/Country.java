package za.co.whcb.tp2.rikitours.domain.tour;
import java.io.Serializable;

import za.co.whcb.tp2.rikitours.domain.tour.City;
/**
 * Created by Encore on 9/17/2016.
 */
public class Country implements Serializable {
    private Long id;
	private String name;
    private String description;
    private String image;

    public Country(Builder builder){
        this.id=builder.id;
        this.name=builder.name;
        this.description = builder.description;
        this.image = builder.image;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getImage(){
        return image;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder{
        private Long id;
        private String name;
        private String description;
        private String image;

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder name(String name){
            this.name=name;
            return  this;
        }

        public Builder image(String image){
            this.image = image;
            return  this;
        }

        public Builder description(String description){
            this.description=description;
            return  this;
        }

        public Builder copy(Country country){
            this.id=country.id;
            this.name=country.name;
            this.description = country.description;
            this.image = country.image;

            return this;
        }
        public Country build(){
            return new Country(this);
        }

    }
}