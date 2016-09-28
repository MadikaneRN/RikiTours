package za.co.whcb.tp2.rikitours.domain;
import za.co.whcb.tp2.rikitours.domain.tour.City;
/**
 * Created by Encore on 9/17/2016.
 */
public class Address{
    private Long id, String streetNumber,String streetName,City city;

    public Address(Builder builder){
        this.id=builder.id;
        this.streetNumber=builder.streetNumber;
        this.streetName=builder.streetName;
        this.city=builder.city;
    }
    public Long getId(){
        return id;
    }

    public String getStreetName(){
        return streetName;
    }

    public String getStreetNumber(){
        return streetNumber;
    }

    public City getCity(){
        return city;
    }

    public static class Builder{
        Long id, String streetNumber,String streetName,City city;

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder number(String streetNumber){
            this.streetNumber=streetNumber;
            return this;
        }

        public Builder name(String streetName){
            this.streetName=streetName;
            return this;
        }

        public Builder city(City city){
            this.city=city;
            return this;
        }
        public Builder copy(Address address){
            this.id=address.id;
            this.streetNumber=address.streetNumber;
            this.streetName=address.streetName;
            this.city=address.city;

            return this;
        }
        public Address build(){
            return new Address(this);
        }
    }
}