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
    private Contacts contactDetails;


    public Customer(Builder builderObj)
    {
        name=builderObj.name;
        surname=builderObj.surname;
        id=builderObj.id;
    }

    public Customer(long id, String name, String surname, String customer_no, String email, Contacts contactDetails) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.contactDetails = contactDetails;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    private Customer(){}

    public static class Builder{
        private long id;
        private String name;
        private String surname;
        Contacts contactDetails;

        public Builder id(int id){
            this.id=id;
            return this;
        }
        public Builder id(long id){
            this.id =  id;
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

        public Builder copyObj(Customer custObj){
            this.id=custObj.getId();
            this.name=custObj.getName();
            this.surname=custObj.getSurname();
            return this;

        }
        public Customer build(){return new Customer(this);}


    }

}
