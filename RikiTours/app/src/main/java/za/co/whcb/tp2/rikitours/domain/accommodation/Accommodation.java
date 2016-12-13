package za.co.whcb.tp2.rikitours.domain.accommodation;

import java.io.Serializable;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by Madikane on 9/17/2016.
 */
<<<<<<< HEAD
public class Accommodation {
=======
public class Accommodation implements Serializable {

>>>>>>> 41e99089259feb00b77256ad1ea3db78ff96b266
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
<<<<<<< HEAD
        this.amountToPay = builder.amountToPay;
        this.bookedInDate = builder.bookedInDate;
        this.bookedOutDate = builder.bookedOutDate;
    }

=======
        this.bookedOutDate = builder.bookedOutDate;
        this.bookedInDate = builder.bookedInDate;
        this.amountToPay = builder.amountToPay;
    }


>>>>>>> 41e99089259feb00b77256ad1ea3db78ff96b266
    public long getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public Customer getCustomer() {
        return customer;
    }

<<<<<<< HEAD
=======
    public String getBookedOutDate() {
        return bookedOutDate;
    }

>>>>>>> 41e99089259feb00b77256ad1ea3db78ff96b266
    public String getBookedInDate() {
        return bookedInDate;
    }

<<<<<<< HEAD
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
=======
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
>>>>>>> 41e99089259feb00b77256ad1ea3db78ff96b266
            this.bookedOutDate = value;
            return this;
        }

<<<<<<< HEAD
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


=======

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

>>>>>>> 41e99089259feb00b77256ad1ea3db78ff96b266
}
