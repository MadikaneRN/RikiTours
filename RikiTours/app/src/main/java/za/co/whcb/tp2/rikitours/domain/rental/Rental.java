package za.co.whcb.tp2.rikitours.domain.rental;

import java.io.Serializable;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by berka on 9/17/2016.
 */
public class Rental implements Serializable{
    private long id;
    private Customer customer;
    private Vehicle vehicle;

    private String  status;
    private String rentDate;
    private String returnDate;
    // private double amountToPay, estimatedAmount;

    public Rental(Builder builder){
        this.id = builder.id;
        this.customer = builder.customer;
        this.vehicle = builder.vehicle;
        this.rentDate = builder.rentDate;
        this.returnDate = builder.returnDate;
        this.status = builder.status;
    }


    public long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getStatus() {
        return status;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getRentDate() {
        return rentDate;
    }


    public static class Builder
    {
        private long id;
        private Customer customer;
        private Vehicle vehicle;

        private String  status;
        private String rentDate;
        private String returnDate;


        public Builder id(long value){
            this.id = value;
            return this;
        }

        public Builder customer(Customer value){
            this.customer = value;
            return this;
        }


        public Builder vehicle(Vehicle value){
            this.vehicle = value;
            return this;
        }


        public Builder status(String value){
            this.status = value;
            return this;
        }

        public Builder rentDate(String value){
            this.rentDate = value;
            return this;
        }


        public Builder returnDate(String value){
            this.returnDate = value;
            return this;
        }


        public Builder copy(Rental value){
            this.id = value.id;
            this.status = value.status;
            this.vehicle = value.vehicle;
            this.customer = value.customer;
            this.returnDate = value.returnDate;
            this.rentDate = value.rentDate;
            return this;
        }

        public Rental build()
        {
            return new Rental(this);
        }

    }



}
