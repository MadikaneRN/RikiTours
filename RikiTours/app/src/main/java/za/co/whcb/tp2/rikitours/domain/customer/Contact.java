package za.co.whcb.tp2.rikitours.domain.customer;

import java.io.Serializable;

/**
 * Created by Tamonne on 2016/04/16.
 */
public class Contact implements Serializable {

    private Long id;
	private String customerId;
    private String phoneNo;
    private String landlineNo;
    private String name;

    public Contact(Builder buildObj){
	
        phoneNo=buildObj.phoneNo;
        landlineNo=buildObj.landlineNo;
		 customerId=buildObj.customerId;
        id=buildObj.id;
    }

    public Long getId() {
        return id;
    }
	
    public String getCustomeId() {
        return customerId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
	
    public String getName() {
        return name;
    }
    public String getLandlineNo() {
        return landlineNo;
    }

    private Contact(){}

    public static class Builder {
        private Long id;
        private String phoneNo;
        private String landlineNo;
		private String customerId;
		
       public Builder customerId (String customerId){
        this.customerId=customerId;
            return this;

        }
        public Builder phoneNo (String phoneNo){
        this.phoneNo=phoneNo;
            return this;

        }
        public Builder id (Long id){
            this.id=id;
            return this;

        }

        public Builder landlineNo(String landlineNo){
            this.landlineNo=landlineNo;
            return this;
        }
    public Builder copyObj(Contact contact){

        this.phoneNo=contact.getPhoneNo();
		 this.customerId=contact.getCustomeId();
        this.landlineNo=contact.getLandlineNo();
        this.id=contact.getId();
        return this;
    }
        public Contact build (){
            return new Contact(this);
        }
    }


}
