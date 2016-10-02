package za.co.whcb.tp2.rikitours.domain.rental;

/**
 * Created by kelly on 10/2/2016.
 */
public class Reservations {
    private String id;
    private String pickUpDate;
    private String returnedDate;
    private  String location;
    private String vehicleType; //to be changed into a class (embedded)

    public Reservations() {
    }

    public Reservations(String id, String pickUpDate, String returnedDate, String location, String vehicleType) {
        this.id = id;
        this.pickUpDate = pickUpDate;
        this.returnedDate = returnedDate;
        this.location = location;
        this.vehicleType = vehicleType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public static class Builder {
        private String id;
        private String pickUpDate;
        private String returnedDate;
        private  String location;
        private String vehicleType; //to be changed into a class (embedded)

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder pickUpDate(String pickUpDate) {
            this.pickUpDate = pickUpDate;
            return this;
        }
        public Builder returnedDate(String returnedDate) {
            this.returnedDate = returnedDate;
            return this;
        }
        public Builder location(String location) {
            this.location = location;
            return this;
        }
        public Builder vehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
            return this;
        }
        public Builder copy(Reservations reservations){
            this.id = reservations.id;
            this.pickUpDate = reservations.pickUpDate;
            this.returnedDate = reservations.returnedDate;
            this.location = reservations.location;
            this.vehicleType = reservations.vehicleType;

            return this;
        }
    }
}
