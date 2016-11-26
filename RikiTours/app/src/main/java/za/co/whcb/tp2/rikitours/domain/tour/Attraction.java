package za.co.whcb.tp2.rikitours.domain.tour;

import java.io.Serializable;

/**
 * Created by Encore on 9/17/2016.
 */
public class Attraction implements Serializable {
    private long id;
    private Country countryId;
    private AttractionDescription attractionDescription;

    public Attraction() {
    }

    public Attraction(Builder builder) {
        this.attractionDescription = builder.attractionDescriptionId;
        this.countryId = builder.countryId;
        this.id = builder.id;
    }

    public long getId() {
        return id;
    }


    public Country getCountryId() {
        return countryId;
    }


    public AttractionDescription getAttractionDescription() {
        return attractionDescription;
    }

    public static class Builder{
        private long id;
        private Country countryId;
        private AttractionDescription attractionDescriptionId;

        public Builder id(Long id){
            this.id = id;
            return this;
        }


        public Builder country(Country country){
            this.countryId = country;
            return this;
        }

        public Builder attractionDescription(AttractionDescription attractionDescription){
            this.attractionDescriptionId = attractionDescription;
            return this;
        }

        public Builder copy(Attraction attraction){
            this.id = attraction.id;
            this.countryId = attraction.countryId;
            this.attractionDescriptionId = attraction.attractionDescription;

            return this;
        }
        public Attraction build() {
            return new Attraction(this);


        }
    }
}
