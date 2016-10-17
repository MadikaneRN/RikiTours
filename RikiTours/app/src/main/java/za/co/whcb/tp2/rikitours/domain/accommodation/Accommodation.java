package za.co.whcb.tp2.rikitours.domain.accommodation;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by Kishan on 9/17/2016.
 */
public class Accommodation {
    private long id;

    private Customer customer;
    private int noGuests;
    private String bookedInDate;
    private String bookedOutDate;



    public Accommodation() {
    }
    public Accommodation(Builder builder) {
        this.id = builder.id;
        this.customer = builder.customer;
        this.bookedInDate = builder.bookedInDate;
        this.bookedOutDate = builder.bookedOutDate;
        this.noGuests = builder.noGuests;
    }

    public long getId() {
        return id;
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






    public int getNoGuests() {
        return noGuests;
    }


    public static class Builder{

        private long id;

        private Customer customer;
        private int noGuests;
        private String bookedInDate;
        private String bookedOutDate;


        public Builder id( long id){
            this.id = id;
            return this;
        }


        public Builder customer(Customer customer){
            this.customer = customer;
            return this;
        }

        public Builder noGuests(int noGuests){
            this.noGuests = noGuests;
            return this;
        }

        public Builder bookedInDate(String bookedInDate){
            this.bookedInDate = bookedInDate;
            return this;
        }
        public Builder bookedOutDate(String bookedOutDate){
            this.bookedOutDate = bookedOutDate;
            return this;
        }


        public Builder copy(Accommodation accommodation){
            this.id = accommodation.id;

            this.noGuests = accommodation.noGuests;
            this.bookedInDate = accommodation.bookedInDate;
            this.bookedOutDate = accommodation.bookedOutDate;

            return this;
        }

        public Accommodation build() {
            return new Accommodation(this);
        }
    }


}

