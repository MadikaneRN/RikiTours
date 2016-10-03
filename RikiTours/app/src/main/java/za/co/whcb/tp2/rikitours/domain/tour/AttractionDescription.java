package za.co.whcb.tp2.rikitours.domain.tour;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class AttractionDescription {
    private String name, city,description, image;

    public AttractionDescription() {
    }

    public AttractionDescription(Builder builder) {
        this.name = builder.name;
        this.city = builder.city;
        this.description = builder.description;
        this.image = builder.image;
    }

    public String getName() {
        return name;
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
        private String name, city,description, image;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder city(String city){
            this.city = city;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder image(String image){
            this.image = image;
            return this;
        }

        public Builder copy(AttractionDescription attraction){
            this.name = attraction.name;
            this.city = attraction.city;
            this.description = attraction.description;
            this.image = attraction.image;

            return this;
        }

        public AttractionDescription build() {
            return new AttractionDescription(this);
        }
    }
}
