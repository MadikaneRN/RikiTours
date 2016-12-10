package za.co.whcb.tp2.rikitours.domain.customer;

import za.co.whcb.tp2.rikitours.domain.Person;

/**
 * Created by berka on 9/9/2016.
 */
public class Customer implements Person{
    private long id;
    private String name;
    private String surname;
    private String customer_no;
    private String email;

    public Customer(Builder builderObj)
    {
        name=builderObj.name;
        surname=builderObj.surname;
        customer_no=builderObj.customer_no;
        id=builderObj.id;
    }

    public Customer(long id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.customer_no = "";
        this.email = email;
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

    public String getEmail() {
        return customer_no;
    }

    public String getCustomerNumber() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static class Builder{
        private long id;
        private String name;
        private String surname;
        private String customer_no;
        private String email;

        public Builder id(int id){
            this.id=id;
            return this;
        }
        public Builder id(long id){
            this.id =  id;
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

        public Builder customer_no(String customer_no){
            this.customer_no=customer_no;
            return this;
        }
        public Builder copyObj(Customer custObj){
            this.id=custObj.getId();
            this.name=custObj.getName();
            this.surname=custObj.getSurname();
            this.customer_no=custObj.getCustomerNumber();
            this.email = custObj.getEmail();
            return this;

        }
        public Customer build(){return new Customer(this);}


    }

}
