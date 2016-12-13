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
    private String postalCode;
    private City city;

    public Address(Builder builder){
        this.id=builder.id;
        this.streetNumber=builder.streetNumber;
        this.streetName=builder.streetName;
        this.city=builder.city;
        this.flatNo = builder.flatNo;

    }
    public Address(Long id,String flatNo, String streetName,String postalCode,City city){
        this.id = id;
        this.flatNo = flatNo;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.city = city;
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

    public City getCity(){
        return city;
    }


    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public static class Builder{
        private Long id;
        private String flatNo;
        private String streetNumber;
        private String streetName;
        private City city;


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


        public Builder city(City city){
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