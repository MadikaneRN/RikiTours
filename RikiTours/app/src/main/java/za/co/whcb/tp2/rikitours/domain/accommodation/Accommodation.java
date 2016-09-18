package za.co.whcb.tp2.rikitours.domain.accommodation;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by berka on 9/17/2016.
 */
public class Accommodation {
    private String id;
    private Room room;
    private Customer customer;
    private String bookedInDate;
    private String bookedOutDate;
    private double amountToPay;

    public Accommodation() {
    }

    public Accommodation(String id, Room room, Customer customer, String bookedInDate, String bookedOutDate) {
        this.id = id;
        this.room = room;
        this.customer = customer;
        this.bookedInDate = bookedInDate;
        this.bookedOutDate = bookedOutDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getBookedInDate() {
        return bookedInDate;
    }

    public void setBookedInDate(String bookedInDate) {
        this.bookedInDate = bookedInDate;
    }

    public String getBookedOutDate() {
        return bookedOutDate;
    }

    public void setBookedOutDate(String bookedOutDate) {
        this.bookedOutDate = bookedOutDate;
    }

    public double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }
}
