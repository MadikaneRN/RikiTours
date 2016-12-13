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



    public Contacts(Long id, String cellNumber,String workNumber,Address address){
        this.id = id;
        this.cellNumber = cellNumber;
        this.workNumber = workNumber;
        this.address = address;
    }

    public Contacts(Builder builder){
        this.id=builder.id;
        this.cellNumber=builder.cellNumber;
        this.workNumber=builder.workNumber;
        this.address=builder.address;
    }

    public String getCellNumber(){
        return cellNumber;
    }

    public Long getId() {
        return id;
    }

    public String getWorkNumber(){
        return workNumber;
    }

    public Address getAddress(){
        return address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static class Builder {

        private Long id;
        private String cellNumber;
        private String workNumber;
        private Address address;


        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder cellNumber(String cellNumber){
            this.cellNumber=cellNumber;
            return this;
        }

        public Builder workNo(String workNumber){
            this.workNumber =workNumber;
            return this;
        }

        public Builder address(Address address){
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