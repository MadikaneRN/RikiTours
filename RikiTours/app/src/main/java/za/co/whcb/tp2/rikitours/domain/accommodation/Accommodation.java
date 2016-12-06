package za.co.whcb.tp2.rikitours.domain.accommodation;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by Madikane on 9/17/2016.
 */
public class Accommodation {
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
        this.amountToPay = builder.amountToPay;
        this.bookedInDate = builder.bookedInDate;
        this.bookedOutDate = builder.bookedOutDate;
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

    public String getBookedInDate() {
        return bookedInDate;
    }

    public String getBookedOutDate() {
        return bookedOutDate;
    }

    public double getAmountToPay() {
        return amountToPay;
    }

    public static class Builder {
        private long id;
        private Room room;
        private Customer customer;
        private String bookedInDate;
        private String bookedOutDate;
        private double amountToPay;


        public Builder id(long id) {
            this.id = id;
            return this;
        }


        public Builder room(Room value) {
            this.room= value;
            return this;
        }

        public Builder customer(Customer value) {
            this.customer = value;
            return this;
        }

        public Builder amountToPay(double value) {
            this.amountToPay = value;
            return this;
        }

        public Builder bookedOutDate(String value) {
            this.bookedOutDate = value;
            return this;
        }

        public Builder bookedInDate(String value) {
            this.bookedInDate = value;
            return this;
        }


        public Builder copy(Accommodation accommodation){
            this.id = accommodation.id;
            this.customer = accommodation.customer;
            this.room = accommodation.room;
            this.bookedInDate = accommodation.bookedInDate;
            this.bookedOutDate = accommodation.bookedOutDate;
            return this;
        }

        public Accommodation build(){return new Accommodation(this);}

    }


}
