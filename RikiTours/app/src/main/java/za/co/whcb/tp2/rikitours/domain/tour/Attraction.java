package za.co.whcb.tp2.rikitours.domain.tour;

import java.io.Serializable;

/**
 * Created by Encore on 9/17/2016.
 */
public class Attraction implements Serializable {
    private Long id;
    private Country country;
    private AttractionDescription attractionDescription;

    public Attraction() {
    }

    public Attraction(Builder builder) {
        this.attractionDescription = builder.attractionDescriptionId;
        this.country = builder.country;
        this.id = builder.id;
    }

    public Long getId() {
        return id;
    }


    public Country getCountry() {
        return country;
    }


    public AttractionDescription getAttractionDescription() {
        return attractionDescription;
    }

    public static class Builder{
        private Long id;
        private Country country;
        private AttractionDescription attractionDescriptionId;

        public Builder id(Long id){
            this.id = id;
            return this;
        }


        public Builder country(Country country){
            this.country = country;
            return this;
        }

        public Builder attractionDescription(AttractionDescription attractionDescription){
            this.attractionDescriptionId = attractionDescription;
            return this;
        }

        public Builder copy(Attraction attraction){
            this.id = attraction.id;
            this.country = attraction.country;
            this.attractionDescriptionId = attraction.attractionDescription;

            return this;
        }
        public Attraction build() {
            return new Attraction(this);


        }
    }
}
