package za.co.whcb.tp2.rikitours.domain.rental;

import java.io.Serializable;

/**
 * Created by Lindo on 9/17/2016.
 */
public class Rental implements Serializable {
    private long id;
    private Reservations reservation;
    private boolean status;

    public Rental(Builder builder){
        this.id = builder.id;
        this.reservation = builder.reservation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Reservations getReservation() {
        return reservation;
    }

    public void setReservation(Reservations reservation) {
        this.reservation = reservation;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static class Builder {
        private long id;
        private Reservations reservation;
        private boolean status;

        public Builder id(long id) {
            this.id = id;
            return this;
        }
        public Builder reservation(Reservations reservation) {
            this.reservation = reservation;
            return this;
        }
        public Builder status(boolean status){
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

