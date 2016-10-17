package za.co.whcb.tp2.rikitours.domain.accommodation;

/**
 * Created by berka on 9/17/2016.
 */
public class Room {
    private String  size, description, image;
    private long id;
    private long hotelId;
    private RoomType roomType;
    private double price;

    public Room() {
    }


    public Room(Builder builder) {
        this.id = builder.id;
        this.size = builder.size;
        this.roomType = builder.roomType;
        this.description = builder.description;
        this.hotelId = builder.hotelId;
        this.price = builder.price;
        this.image = builder.image;
    }

    public long getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

    public long getHotelId() {
        return hotelId;
    }

     public RoomType getRoomType(){return roomType;}
     public double getPrice(){ return price;}
     public String getImage(){ return image;}



    public static class Builder {
        private String size, description;
        private long id;
        private long hotelId;
        private RoomType roomType;
        private String image;
        private double price;




        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder size(String size) {
            this.size = size;
            return this;
        }

        public Builder roomType(RoomType roomType) {
            this.roomType = roomType;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder hotelId(long hotelId) {
            this.hotelId = hotelId;
            return this;
        }
        public Builder image(String image) {
            this.image = image;
            return this;
        }
        public Builder price(double price) {
            this.price = price;
            return this;
        }




        public Builder copy(Room room) {
            this.id = room.id;

            this.size = room.size;
            this.roomType = room.roomType;
            this.description = room.description;
            this.hotelId = room.hotelId;
            this.image=room.image;
            this.price=room.price;

            return this;
        }

        public Room build() {
            return new Room(this);
        }
    }
}