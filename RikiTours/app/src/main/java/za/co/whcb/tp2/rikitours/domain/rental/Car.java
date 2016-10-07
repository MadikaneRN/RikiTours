package za.co.whcb.tp2.rikitours.domain.rental;

import java.io.Serializable;

/**
 * Created by berka on 9/17/2016.
 */
public class Car implements Serializable {
    
    private long id;
    private String regNumber;

    public Car() {
    }
    
    public long getId() {
        return id;
    }

    public String getRegistrationNumber()
    {
        return regNumber;
    }
    
    public Car(Builder builder) {

        this.id = builder.id;
        this.regNumber = builder.regNumber;
        
    }
    
    public static class Builder{
        private long id;
        private String regNumber;

        public Builder id(long value){
            this.id = value;
            return this;
        }
        public Builder regNumber(String value){
            this.regNumber = value;
            return this;
        }
      

        public Builder copy(Car value){
            this.id = value.id;
            this.regNumber = value.regNumber;
            return this;
        }

        public Car build(){return new Car(this);}
    }

    

}
