package za.co.whcb.tp2.rikitours.domain.accommodation;

/**
 * Created by berka on 9/17/2016.
 */
public class Room {
    private String id, size, type, description;
    private String hotelId;

    public Room() {
    }

    public Room(String id, String size, String type, String description, String hotelId) {
        this.id = id;
        this.size = size;
        this.type = type;
        this.description = description;
        this.hotelId = hotelId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
}
