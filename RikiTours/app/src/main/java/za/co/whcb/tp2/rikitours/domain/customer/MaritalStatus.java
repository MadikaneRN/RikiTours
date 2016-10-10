package za.co.whcb.tp2.rikitours.domain.customer;

import java.io.Serializable;

/**
 * Created by Tamonne on 2016/04/16.
 */
public class MaritalStatus implements Serializable {

    private Long id;
    private String  customerId;
    private String single;
    private String married;
    private String divorced;


    public MaritalStatus(Builder buildObj){
	    customerId=buildObj.customerId;
        single=buildObj.single;
        married=buildObj.married;
        divorced=buildObj.divorced;
        id=buildObj.id;
    }

    public Long getId() {
        return id;
    }

    public String getIsSingle() {
        return single;
    }

    public String getIsMarried() {
        return married;
    }
	
	public String getCustomerId() {
        return customerId;
    }

    public String getIsDivorced() {
        return divorced;
    }


    private MaritalStatus(){}

    public static class Builder {
        private Long id;
     private String customerId;
        private String single;
        private String married;
        private String divorced;

 public Builder customerId (String customerId){
        this.customerId=customerId;
            return this;

        }
        public Builder single (String single){
        this.single=single;
            return this;

        }
        public Builder married (String married){
        this.married=married;
            return this;

        }
        public Builder id (Long id){
            this.id=id;
            return this;

        }

        public Builder divorced(String divorced){
            this.divorced=divorced;
            return this;
        }
    public Builder copyObj(MaritalStatus maritalStatus){
        this.customerId=maritalStatus.getCustomerId();
        this.married=maritalStatus.getIsMarried();
        this.divorced=maritalStatus.getIsDivorced();
        this.single=maritalStatus.getIsSingle();
        this.id=maritalStatus.getId();
        return this;
    }
        public MaritalStatus build (){
            return new MaritalStatus(this);
        }
    }


}
