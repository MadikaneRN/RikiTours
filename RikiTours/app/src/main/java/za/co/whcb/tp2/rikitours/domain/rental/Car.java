package za.co.whcb.tp2.rikitours.domain.rental;

import java.io.Serializable;

/**
 * Created by berka on 9/17/2016.
 */
public class Car implements Serializable {
    
    private long id;
    private String regNumber;
    private String carType;

    public Car() {
    }
    
    public long getId() {
        return id;
    }

    public String getRegistrationNumber()
    {
        return regNumber;
    }

    public String getCarType()
    {
        return carType;
    }
    
    public Car(Builder builder) {

        this.id = builder.id;
        this.regNumber = builder.regNumber;
        this.carType = builder.carType;
    }
    
    public static class Builder{
        private long id;
        private String regNumber;
        private String carType;

        public Builder id(long value){
            this.id = value;
            return this;
        }
        public Builder regNumber(String value){
            this.regNumber = value;
            return this;
        }
      
        public Builder carType(String value)
        {
            this.carType = value;
            return this;
        }

        public Builder copy(Car value){
            this.id = value.id;
            this.regNumber = value.regNumber;
            this.carType = value.carType;
            return this;
        }

        public Car build(){return new Car(this);}
    }

    

}
