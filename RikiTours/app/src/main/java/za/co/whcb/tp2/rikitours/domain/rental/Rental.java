package za.co.whcb.tp2.rikitours.domain.rental;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by berka on 9/17/2016.
 */
public class Rental {
    private String id;
    private String vehicle; //to be changed into a class (embedded)
    private String rentDate, returnDate;
    private double amountToPay;

    public Rental() {
    }

    public Rental(String id, String vehicle, String rentDate, String returnDate, double amountToPay) {
        this.id = id;
        this.vehicle = vehicle;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.amountToPay = amountToPay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }
}
