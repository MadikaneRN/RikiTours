package za.co.whcb.tp2.rikitours.domain.rental;

import java.io.Serializable;

/**
 * Created by berka on 10/10/2016.
 */
public class Driver implements Serializable{
    private long id;
    private String fname;
    private String active; //boolean
    private String driverId;


    public Driver() {
    }


    public Driver(Builder builder){
        this.id = builder.id;
        this.fname = builder.fname;
        this.active = builder.active;
        this.driverId = builder.driverId;

    }


    public long getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getActive() {
        return active;
    }

    public String getDriverId() {
        return driverId;
    }




    public static class Builder
    {
        private long id;
        private String fname;
        private String active;
        private String driverId;

        public Builder id(Long value){
            this.id = value;
            return this;
        }

        public Builder fname(String value){
            this.fname = value;
            return this;
        }

        public Builder active(String value){
            this.active = value;
            return this;
        }


        public Builder driverId(String value){
            this.driverId = value;
            return this;
        }



        public Builder copy(Driver value){
            this.id = value.id;
            this.fname = value.fname;
            this.driverId = value.driverId;
            this.active = value.active;
            return this;
        }

        public Driver build()
        {
            return new Driver(this);
        }



    }


}
