package za.co.whcb.tp2.rikitours.domain.rental;

import java.io.Serializable;

/**
 * Created by Scorpian on 2016-10-03.
 */

public class Vehicle implements Serializable{

    private long id;
    private String vehicleName;
    private String vehicleModel;
    private String vehicleYear;


    public Vehicle() {
    }

    public long getId() {
        return id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleYear() {
        return vehicleYear;
    }


    public static class Builder{
        private long id;
        private String vehicleName;
        private String vehicleModel;
        private  String vehicleYear;

        public Builder id(Long value){
            this.id = value;
            return this;
        }

        public Builder vehicleName(String value){
            this.vehicleName = value;
            return this;
        }

        public Builder vehicleModel(String value){
            this.vehicleModel = value;
            return this;
        }

        public Builder vehicleYear(String value){
            this.vehicleYear = value;
            return this;
        }

        public Builder copy(Vehicle value){
            this.id = value.id;
            this.vehicleName = value.vehicleName;
            this.vehicleModel = value.vehicleModel;
            this.vehicleYear = value.vehicleYear;
            return this;
        }

        public Vehicle build()
        {
            return new Vehicle(this);
        }
    }

    public Vehicle(Builder builder){
        this.id = builder.id;
        this.vehicleName = builder.vehicleName;
        this.vehicleModel = builder.vehicleModel;
        this.vehicleYear = builder.vehicleYear;
    }





}
