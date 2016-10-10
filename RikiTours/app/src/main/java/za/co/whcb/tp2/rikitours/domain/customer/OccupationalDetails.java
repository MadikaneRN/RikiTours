package za.co.whcb.tp2.rikitours.domain.customer;

import java.io.Serializable;

/**
 * Created by Tamonne on 2016/04/16.
   Customer Work/Occupation Details.
 */
public class OccupationalDetails implements Serializable {

    private Long id;
    private String customerId;
    private String position;
    private String jobType;
    private String companyName;

    public OccupationalDetails(Builder buildObj){

        customerId=buildObj.customerId;
        position=buildObj.position;
        companyName=buildObj.companyName;
        jobType=buildObj.jobType;
        id=buildObj.id;
    }

    public Long getId() {
        return id;
    }
	 public String getPosition() {
        return position;
    }

 public String getCustomerId() {
        return customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobType() {
        return jobType;
    }

    private OccupationalDetails(){}

    public static class Builder {
        private Long id;
	    private String position;
	    private String customerId;
        private String companyName;
        private String jobType;

		  public Builder customerId (String customerId){
        this.customerId=customerId;
            return this;

        }
		public Builder position (String position){
        this.position=position;
            return this;

        }
        public Builder companyName (String companyName){
        this.companyName=companyName;
            return this;

        }
        public Builder id (Long id){
            this.id=id;
            return this;

        }

        public Builder jobType(String jobType){
            this.jobType=jobType;
            return this;
        }
    public Builder copyObj(OccupationalDetails occupationalDetails){

	    this.customerId=occupationalDetails.getCustomerId();
	    this.position=occupationalDetails.getPosition();
        this.companyName=occupationalDetails.getCompanyName();
        this.jobType=occupationalDetails.getJobType();
        this.id=occupationalDetails.getId();
        return this;
    }
        public OccupationalDetails build (){
            return new OccupationalDetails(this);
        }
    }


}
