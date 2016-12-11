package za.co.whcb.tp2.rikitours.domain.accommodation;

import java.io.Serializable;
import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.domain.gallery.RikiImage;

/**
 * Created by berka on 9/17/2016.
 */
public class Room implements Serializable {
    private String  size, type, description;
    private long id;
    private double price ;
    private Hotel hotel;
    private ArrayList<RikiImage> images;

       public Room() {
    }

    public Room(long id, String size, String type, String description, Hotel hotel) {
        this.id = id;
        this.size = size;
        this.type = type;
        this.description = description;
        this.hotel = hotel;
        images = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
}
