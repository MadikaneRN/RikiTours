package za.co.whcb.tp2.rikitours.domain.accommodation;

/**
 * Created by berka on 9/17/2016.
 */
public class Room {
    private long id;
    private String size;
    private String type;
    private String description;

    private Hotel hotel;

    public Room() {
    }

    public Room(Builder builder){
        this.id = builder.id;
        this.hotel = builder.hotel;
        this.type = builder.type;
        this.size = builder.size;
        this.description = builder.description;
    }


    public long getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Hotel getHotel() {
        return hotel;
    }



    public static class Builder {
        private long id;

        private Hotel hotel;
        private String size;
        private String type;
        private String description;

        public Builder id(long id) {
            this.id = id;
            return this;
        }
        public Builder hotel(Hotel hotel) {
            this.hotel = hotel;
            return this;
        }
        public Builder size(String value){
            this.size = value;
            return this;
        }
        public Builder type(String value)
        {
            this.type = value;
            return this;
        }
        public Builder description (String value)
        {
            this.description = value;
            return this;
        }

        public Builder copy(Room room){
            this.id = room.id;
            this.type = room.type;
            this.hotel = room.hotel;
            this.size = room.size;
            this.description = room.description;
            return this;
        }

        public Room build(){return new Room(this);}
    }

}
