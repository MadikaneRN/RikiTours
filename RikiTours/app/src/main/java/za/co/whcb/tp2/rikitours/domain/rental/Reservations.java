package za.co.whcb.tp2.rikitours.domain.rental;

import java.io.Serializable;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by Lindo on 10/2/2016.
 */
public class Reservations implements Serializable {
    private long id;
    private Customer customer;
    private Vehicle vehicle;
    private String pickUpDate;
    private String returnedDate;
    private double amountToPay;


    public Reservations(Builder builder){
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

        public Builder copy(Reservations reservations){
            this.id = reservations.id;
            this.customer = reservations.customer;
            this.vehicle = reservations.vehicle;
            this.pickUpDate = reservations.pickUpDate;
            this.returnedDate = reservations.returnedDate;
            this.amountToPay = reservations.amountToPay;
            return this;
        }
        public Reservations build(){return new Reservations(this);}
    }
}
