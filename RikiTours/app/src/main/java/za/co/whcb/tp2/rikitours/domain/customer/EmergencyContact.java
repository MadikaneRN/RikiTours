package za.co.whcb.tp2.rikitours.domain.customer;

import java.io.Serializable;

/**
 * Created by Tamonne on 2016/04/16.
   Customer emergency Contact.
 */
public class EmergencyContact implements Serializable {

    private Long id;
    private String customerId;
    private String name;
    private String surname;
    private String relationship;
	 private String phoneNo;
     private String landlineNo;

    public EmergencyContact(Builder buildObj){

        customerId=buildObj.customerId;
        name=buildObj.name;
		phoneNo=buildObj.phoneNo;
        landlineNo=buildObj.landlineNo;
        relationship=buildObj.relationship;
        surname=buildObj.surname;
        id=buildObj.id;
    }

    public Long getId() {
        return id;
    }
	 public String getName() {
        return name;
    }

 public String getCustomerId() {
        return customerId;
    }
public String getPhoneNo() {
        return phoneNo;
    }
	public String getLandlineNo() {
        return landlineNo;
    }
	
    public String getRelationship() {
        return relationship;
    }

    public String getSurname() {
        return surname;
    }

    private EmergencyContact(){}

    public static class Builder {
        private Long id;
	    private String name;
	    private String customerId;
        private String relationship;
        private String surname;
		private String phoneNo;
        private String landlineNo;

		  public Builder customerId (String customerId){
        this.customerId=customerId;
            return this;

        }
		 public Builder phoneNo (String phoneNo){
        this.phoneNo=phoneNo;
            return this;

        }
		 public Builder landlineNo(String landlineNo){
            this.landlineNo=landlineNo;
            return this;
        }
		
		public Builder name (String name){
        this.name=name;
            return this;

        }
        public Builder relationship (String relationship){
        this.relationship=relationship;
            return this;

        }
        public Builder id (Long id){
            this.id=id;
            return this;

        }

        public Builder surname(String surname){
            this.surname=surname;
            return this;
        }
    public Builder copyObj(EmergencyContact emergencyContact){



	    this.customerId=emergencyContact.getCustomerId();
        this.name=emergencyContact.getName();
        this.relationship=emergencyContact.getRelationship();
        this.phoneNo=emergencyContact.getPhoneNo();
		this.landlineNo=emergencyContact.getLandlineNo();
		this.surname=emergencyContact.getSurname();
        this.id=emergencyContact.getId();
        return this;
    }
        public EmergencyContact build (){
            return new EmergencyContact(this);
        }
    }


}
