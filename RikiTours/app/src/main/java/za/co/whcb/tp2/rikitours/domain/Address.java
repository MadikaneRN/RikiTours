package za.co.whcb.tp2.rikitours.domain;
import za.co.whcb.tp2.rikitours.domain.tour.City;
/**
 * Created by Encore on 9/17/2016.
 */
public class Address{
    private Long id;
    private String flatNo;
    private String streetNumber;
    private String streetName;

    //I changed the city type from 'City to String' because as I see it, I don't have to form a relationship
    // between  address class and the city class. Because the city class defines cities that customers may
    //want to visit. therefore, A city that I might want to visit as a customer is not necessarily the city that
    // I live in.
    private String city;

    public Address(Builder builder){
        this.id=builder.id;
        this.streetNumber=builder.streetNumber;
        this.streetName=builder.streetName;
        this.city=builder.city;
        this.flatNo = builder.flatNo;
    }
    public Long getId(){
        return id;
    }

    public String getFlatNo(){
        return  flatNo;
    }

    public String getStreetName(){
        return streetName;
    }

    public String getStreetNumber(){
        return streetNumber;
    }

    public String getCity(){
        return city;
    }

    public static class Builder{
        private Long id;
        private String flatNo;
        private String streetNumber;
        private String streetName;
        private String city;

        public Builder id(Long id){
            this.id=id;
            return this;
        }
        public Builder flatNo(String flatNo){
            this.flatNo=flatNo;
            return this;
        }

        public Builder streetNumber(String streetNumber){
            this.streetNumber=streetNumber;
            return this;
        }

        public Builder streetName(String streetName){
            this.streetName=streetName;
            return this;
        }

        public Builder city(String city){
            this.city=city;
            return this;
        }
        public Builder copy(Address address){
            this.id=address.id;
            this.streetNumber=address.streetNumber;
            this.streetName=address.streetName;
            this.city=address.city;
            this.flatNo = address.flatNo;


            return this;
        }
        public Address build(){
            return new Address(this);
        }
    }
}