package za.co.whcb.tp2.rikitours.domain.rental;

import za.co.whcb.tp2.rikitours.domain.customer.Customer;

/**
 * Created by berka on 9/17/2016.
 */
public class Rental {
    private String id, status;
    private Car car;
    private Customer customer;
    private String rentDate, returnDate, actualReturnedDate;
    private double amountToPay, estimatedAmount;

    public Rental(String id, Car car, Customer customer, String rentDate) {
        this.id = id;
        this.car = car;
        this.customer = customer;
        this.rentDate = rentDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public String getActualReturnedDate() {
        return actualReturnedDate;
    }

    public void setActualReturnedDate(String actualReturnedDate) {
        this.actualReturnedDate = actualReturnedDate;
    }

    public double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public double getEstimatedAmount() {
        return estimatedAmount;
    }

    public void setEstimatedAmount(double estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }
}
