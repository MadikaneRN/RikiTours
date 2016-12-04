package za.co.whcb.tp2.rikitours.domain.customer;

import za.co.whcb.tp2.rikitours.domain.Contacts;
import za.co.whcb.tp2.rikitours.domain.Person;

/**
 * Created by berka on 9/9/2016.
 */
public class Customer implements Person{
    private long id;
    private String name;
    private String surname;
    private String email;
    private String dob;
    private Contacts contactDetails;


    public Customer(Builder builderObj)
    {
        name=builderObj.name;
        surname=builderObj.surname;
        id=builderObj.id;
        email = builderObj.email;
       // dob = builderObj.dob;
    }

    public Customer(long id, String name, String surname,String email,Contacts contactDetails) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.contactDetails = contactDetails;

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSurname() {
        return surname;
    }

    public String getDob(){
        return dob;
    }

    public Contacts getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(Contacts contactDetails) {
        this.contactDetails = contactDetails;
    }

    private Customer(){}

    public static class Builder{
        private long id;
        private String name;
        private String surname;
        private String email;
        //private String dob;
        Contacts contactDetails;

        public Builder id(int id){
            this.id=id;
            return this;
        }
        public Builder id(long id){
            this.id =  id;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder contactDetails(Contacts contactDetails){
            this.contactDetails = contactDetails;
            return this;
        }

        public Builder name(String name){
            this.name=name;
            return this;
        }



        public Builder surname(String surname){
            this.surname=surname;
            return this;
        }

//        public Builder dob(String dob){
//            this.dob = dob;
//            return this;
//        }

        public Builder copyObj(Customer custObj){
            this.id=custObj.getId();
            this.name=custObj.getName();
            this.surname=custObj.getSurname();
            this.email = custObj.getEmail();
          //  this.dob = custObj.dob;
            return this;

        }
        public Customer build(){return new Customer(this);}


    }

}
