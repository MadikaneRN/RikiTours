package za.co.whcb.tp2.rikitours.domain.rental;

import java.io.Serializable;

/**
 * Created by Lindo on 9/17/2016.
 */
public class Rental implements Serializable {
    private long id;
    private Reservation reservation;
    private String status;

    public Rental(Builder builder){
        this.id = builder.id;
        this.reservation = builder.reservation;
        this.status = builder.status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Builder {
        private long id;
        private Reservation reservation;
        private String status;

        public Builder id(long id) {
            this.id = id;
            return this;
        }
        public Builder reservation(Reservation reservation) {
            this.reservation = reservation;
            return this;
        }
        public Builder status(String status){
            this.status = status;
            return this;
        }

        public Builder copy(Rental rental){
            this.id = rental.id;
            this.reservation = rental.reservation;
            this.status = rental.status;
            return this;
        }
        public Rental build(){return new Rental(this);}
    }
}

