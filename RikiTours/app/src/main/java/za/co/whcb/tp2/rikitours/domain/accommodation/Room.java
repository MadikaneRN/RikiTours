package za.co.whcb.tp2.rikitours.domain.accommodation;

/**
 * Created by berka on 9/17/2016.
 */
public class Room {
    private long id;
    private String size, type, description;
    private Hotel hotel;

    public Room(Builder builder) {
        this.id = builder.id;
        this.size = builder.size;
        this.type = builder.type;
        this.description = builder.description;
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

    public static class Builder {
        private long id;
        private String size, type, description;
        private Hotel hotel;

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder size(String size){
            this.size = size;
            return this;
        }
        public Builder type(String type){
            this.type = type;
            return this;
        }
        public Builder description(String description){
            this.description = description;
            return this;
        }
        public Builder hotel(Hotel hotel){
            this.hotel = hotel;
            return this;
        }
        public Room build(){return new Room(this);}

    }
}
