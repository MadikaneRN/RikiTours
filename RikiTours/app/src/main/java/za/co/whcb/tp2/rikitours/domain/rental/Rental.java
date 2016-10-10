package za.co.whcb.tp2.rikitours.domain.rental;

/**
 * Created by berka on 9/17/2016.
 */
public class Rental {
    private long id;
    private String vehicle; //to be changed into a class (embedded)[connected to Richard's work]
    private String rentDate, returnDate;
    private double amountToPay;

    public Rental(Builder builder){
        this.id = builder.id;
        this.vehicle = builder.vehicle;
        this.rentDate = builder.rentDate;
        this.returnDate = builder.returnDate;
        this.amountToPay = builder.amountToPay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public static class Builder {
        private long id;
        private String vehicle;
        private String rentDate, returnDate;
        private double amountToPay;

        public Builder id(long id) {
            this.id = id;
            return this;
        }
        public Builder vehicle(String vehicle) {
            this.vehicle = vehicle;
            return this;
        }
        public Builder rentDate(String rentDate){
            this.rentDate = rentDate;
            return this;
        }
        public Builder returnDate(String returnDate) {
            this.returnDate = returnDate;
            return this;
        }
        public Builder amountToPay(double amountToPay) {
            this.amountToPay = amountToPay;
            return this;
        }
        public Builder copy(Rental rental){
            this.id = rental.id;
            this.vehicle = rental.vehicle;
            this.rentDate = rental.rentDate;
            this.returnDate = rental.returnDate;
            this.amountToPay = rental.amountToPay;

            return this;
        }
        public Rental build(){return new Rental(this);}
    }
}
