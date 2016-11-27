package za.co.whcb.tp2.rikitours.domain.tour;

import java.io.Serializable;
import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.gallery.RikiImage;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class AttractionDescription implements Serializable {
    private Long id;
    private String name, city,description,image;
    private ArrayList<RikiImage> images;

    public AttractionDescription() {
    }

    public AttractionDescription(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.city = builder.city;
        this.description = builder.description;
        this.image = builder.image;
        this.images = new ArrayList<>();
    }

    public Long getId() {
        return id;
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
    public void addImage(RikiImage newImage){
        this.images.add(newImage);
    }


    public RikiImage getImage(int index){
        if(images.size() > 0 && images.size() > index ||  images.size() == index ){
            return this.images.get(index);
        }
        else{
            return null;
        }

    }

    public ArrayList<RikiImage> getImages() {
        return images;
    }

    public void setImages(ArrayList<RikiImage> images) {
        this.images = images;
    }

    public static class Builder{
        private Long id;
        private String name, city,description, image;

        public Builder id( Long id){
            this.id = id;
            return this;
        }

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
            this.id = attraction.id;
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
