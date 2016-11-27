package za.co.whcb.tp2.rikitours.domain.rental;

import java.io.Serializable;

import za.co.whcb.tp2.rikitours.domain.gallery.RikiImage;

/**
 * Created by Scorpian on 2016-10-03.
 */

public class Vehicle implements Serializable{

    private long id;
    private String vehicleName;
    private String vehicleModel;
    private String vehicleYear;
    private String description;
    private double price;
    private RikiImage carImage;


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

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public RikiImage getCarImage() {
        return carImage;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setVehicleYear(String vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCarImage(RikiImage carImage) {
        this.carImage = carImage;
    }

    public static class Builder{
        private long id;
        private String vehicleName;
        private String vehicleModel;
        private  String vehicleYear;
        private String description;

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
