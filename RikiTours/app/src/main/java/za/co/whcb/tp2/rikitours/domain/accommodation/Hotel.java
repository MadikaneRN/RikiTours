package za.co.whcb.tp2.rikitours.domain.accommodation;

/**
 * Created by Kishan on 9/17/2016.
 */
public class Hotel {
    private String  name, star, description, image;
    private long id;
    public Hotel() {
    }


    public Hotel(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.star = builder.star;
        this.description = builder.description;
        this.image = builder.image;
    }

    public long getId() {
        return id;
    }



    public String getName() {
        return name;
    }



   public String getStar(){return star;}



    public String getDescription() {
        return description;
    }

    public String getImage()
    {
        return image;
    }



    public static class Builder {
        private String name;
        private String star;
        private String description;
        private String image;
        private long id;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder star(String star) {
            this.star = star;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }





        public Builder copy(Hotel hotel) {
            this.id = hotel.id;
            this.name = hotel.name;
            this.star = hotel.star;
            this.description = hotel.description;
            this.image = hotel.image;

            return this;
        }

        public Hotel build() {
            return new Hotel(this);
        }
    }

}