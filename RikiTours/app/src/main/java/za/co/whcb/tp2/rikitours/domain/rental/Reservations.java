package za.co.whcb.tp2.rikitours.domain.rental;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by kelly on 10/2/2016.
 */
public class Reservations {
    private long id;
    private String pickUpDate;
    private String returnedDate;
    private  String location;
    private String vehicleType; //to be changed into a class (embedded)[connected to Richard's work]
    private Customer customer;


    public Reservations(Builder builder){
        this.id = builder.id;
        this.pickUpDate = builder.pickUpDate;
        this.returnedDate = builder.returnedDate;
        this.location = builder.location;
        this.vehicleType = builder.vehicleType;
        this.customer = builder.customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public static class Builder {
        private long id;
        private String pickUpDate;
        private String returnedDate;
        private  String location;
        private String vehicleType;
        private Customer customer;

        public Builder id(long id) {
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
       public Builder customer(Customer customer){
           this.customer = customer;
           return  this;
       }

        public Builder copy(Reservations reservations){
            this.id = reservations.id;
            this.pickUpDate = reservations.pickUpDate;
            this.returnedDate = reservations.returnedDate;
            this.location = reservations.location;
            this.vehicleType = reservations.vehicleType;
            this.customer = reservations.customer;
            return this;
        }
        public Reservations build(){return new Reservations(this);}
    }
}
