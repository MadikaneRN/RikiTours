package za.co.whcb.tp2.rikitours.domain;
import za.co.whcb.tp2.rikitours.domain.Address;
/**
 * Created by Encore on 9/17/2016.
 */
public class Contacts{
    private Long id;
    private String cellNumber;
    private String workNumber;
    private Address address;

    public Contacts(Builder builder){
        this.id=builder.id;
        this.cellNumber=builder.cellNumber;
        this.workNumber=builder.workNumber;
        this.address=builder.address;
    }

    public String getCellNumber(){
        return cellNumber;
    }

    public String getWorkNumber(){
        return workNumber;
    }

    public Address getAddress(){
        return address;
    }

    public static class Builder {
        //Long id, String cellNumber,String workNumber,Address address;
        private Long id;
        private String cellNumber;
        private String workNumber;
        private Address address;

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder number(String cellNumber){
            this.cellNumber=cellNumber;
            return this;
        }

        public Builder name(String workNumber){
            this.workNumber=workNumber;
            return this;
        }

        public Builder name(Address address){
            this.address=address;
            return this;
        }

        public Builder copy(Contacts contacts){
            this.id=contacts.id;
            this.cellNumber=contacts.cellNumber;
            this.workNumber=contacts.workNumber;
            this.address=contacts.address;

            return this;
        }
        public Contacts build(){
            return new Contacts(this);
        }

    }

}