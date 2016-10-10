
package za.co.whcb.tp2.rikitours.domain.customer;

import java.io.Serializable;

public class CustomerAddress implements Serializable{
    private Long id;
    private String street_no;
    private String suburb;
    private String house_no;
    private String postalCode;

    public  CustomerAddress (Builder buildObj){
        suburb=buildObj.suburb;
        street_no=buildObj.street_no;
        house_no=buildObj.house_no;
        postalCode=buildObj.postalCode;
        id=buildObj.id;
    }

    public Long getId() {
        return id;
    }

    public String getHouse_no() {
        return house_no;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreet_no() {
        return street_no;
    }

    public String getSuburb() {
        return suburb;
    }

    private  CustomerAddress (){}

    public static class Builder {
        private Long id;
        private String suburb;
        private String house_no;
        private String street_no;
        private String postalCode;

        public Builder id (Long id) {
            this.id = id;
            return this;

        }

        public Builder postalCode(String postalCode){
            this.postalCode=postalCode;
            return this;
        }
        public Builder suburb (String suburb){
            this.suburb=suburb;
            return this;

        }

        public Builder street_no(String street_no){
            this.street_no=street_no;
            return this;
        }

        public Builder house_no(String house_no){
            this.house_no=house_no;
            return this;
        }
        public Builder copyObj( CustomerAddress address){
            this.id=address.id;
            this.house_no=address.house_no;
            this.street_no=address.street_no;
            this.suburb=address.suburb;
            this.postalCode=address.postalCode;
            return this;
        }
        public  CustomerAddress build (){
            return new  CustomerAddress(this);
        }
    }
}