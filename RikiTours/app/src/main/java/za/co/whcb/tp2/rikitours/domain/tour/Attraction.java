package za.co.whcb.tp2.rikitours.domain.tour;

import za.co.whcb.tp2.rikitours.domain.tour.Country;
/**
 * Created by Encore on 9/17/2016.
 */
public class Attraction {
    private Long id;
    private Long countryId;
    private Long attractionDescriptionId;

    public Attraction() {
    }

    public Attraction(Builder builder) {
        this.attractionDescriptionId = builder.attractionDescriptionId;
        this.countryId = builder.countryId;
        this.id = builder.id;
    }

    public Long getId() {
        return id;
    }


    public Long getCountryId() {
        return countryId;
    }


    public Long getAttractionDescriptionId() {
        return attractionDescriptionId;
    }

    public static class Builder{
        private Long id;
        private Long countryId;
        private Long attractionDescriptionId;

        public Builder id(Long id){
            this.id = id;
            return this;
        }


        public Builder country(Long country){
            this.countryId = country;
            return this;
        }

        public Builder attractionDescription(Long attractionDescription){
            this.attractionDescriptionId = attractionDescription;
            return this;
        }

        public Builder copy(Attraction attraction){
            this.id = attraction.id;
            this.countryId = attraction.countryId;
            this.attractionDescriptionId = attraction.attractionDescriptionId;

            return this;
        }
        public Attraction build() {
            return new Attraction(this);


        }
    }
}
