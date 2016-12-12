package za.co.whcb.tp2.rikitours.domain.accommodation;

import java.io.Serializable;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by berka on 9/17/2016.
 */
public class Accommodation implements Serializable {

    private long id;
    private Room room;
    private Customer customer;
    private String bookedInDate;
    private String bookedOutDate;
    private double amountToPay;

    public Accommodation() {
    }


    public Accommodation(Builder builder){
        this.id = builder.id;
        this.customer = builder.customer;
        this.room = builder.room;
        this.bookedOutDate = builder.bookedOutDate;
        this.bookedInDate = builder.bookedInDate;
        this.amountToPay = builder.amountToPay;
    }


    public long getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getBookedOutDate() {
        return bookedOutDate;
    }

    public String getBookedInDate() {
        return bookedInDate;
    }

    public double getAmountToPay() {
        return amountToPay;
    }


    public static class Builder
    {
        private long id;
        private Room room;
        private Customer customer;
        private String bookedInDate;
        private String bookedOutDate;
        private double amountToPay;



        public Builder id(long value){
            this.id = value;
            return this;
        }

        public Builder Room(Room value){
            this.room = value;
            return this;
        }


        public Builder Customer(Customer value){
            this.customer = value;
            return this;
        }

        public Builder amountTopay(double value){
            this.amountToPay = value;
            return this;
        }


        public Builder bookedInDate(String value){
            this.bookedInDate = value;
            return this;
        }


        public Builder bookedOutDate(String value){
            this.bookedOutDate = value;
            return this;
        }


        public Builder copy(Accommodation value){
            this.id = value.id;
            this.customer = value.customer;
            this.room = value.room;
            this.amountToPay = value.amountToPay;
            this.bookedOutDate = value.bookedOutDate;
            this.bookedInDate = value.bookedInDate;

            return this;
        }

        public Accommodation build()
        {
            return new Accommodation(this);
        }

    }

}
