package za.co.whcb.tp2.rikitours.domain.rental;

import java.io.Serializable;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by Lindo on 10/2/2016.
 */
public class Reservation implements Serializable {
    private long id;
    private Customer customer;
    private Vehicle vehicle;
    private String pickUpDate;
    private String pickupTime;
    private String returnedDate;
    private double amountToPay;
    private String comment;


    public Reservation(Builder builder){
        this.id = builder.id;
        this.customer = builder.customer;
        this.vehicle = builder.vehicle;
        this.pickUpDate = builder.pickUpDate;
        this.returnedDate = builder.returnedDate;
        this.amountToPay = builder.amountToPay;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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

    public double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static class Builder {
        private long id;
        private Customer customer;
        private Vehicle vehicle;
        private String pickUpDate;
        private String returnedDate;
        private  double amountToPay;

        public Builder id(long id) {
            this.id = id;
            return this;
        }
        public Builder customer(Customer customer){
            this.customer = customer;
            return  this;
        }
        public Builder vehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
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
        public Builder amountToPay(double amountToPay) {
            this.amountToPay = amountToPay;
            return this;
        }

        public Builder copy(Reservation reservation){
            this.id = reservation.id;
            this.customer = reservation.customer;
            this.vehicle = reservation.vehicle;
            this.pickUpDate = reservation.pickUpDate;
            this.returnedDate = reservation.returnedDate;
            this.amountToPay = reservation.amountToPay;
            return this;
        }
        public Reservation build(){return new Reservation(this);}
    }
}
