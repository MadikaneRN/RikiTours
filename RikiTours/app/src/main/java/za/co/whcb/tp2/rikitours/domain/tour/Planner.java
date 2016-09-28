package za.co.whcb.tp2.rikitours.domain.tour;
import za.co.whcb.tp2.rikitours.domain.Address;
/**
 * Created by Encore on 9/17/2016.
 */
public class Planner{
    private Long id, String firstName,String lastName,Address address;

    public Planner(Builder builder){
        this.id=builder.id;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.address=builder.address;
    }

    public Long getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Address getAddress(){
        return address;
    }
    public static class Builder{
        Long id, String firstName,String lastName,Address address;

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder first(String firstName){
            this.firstName=firstName;
            return this;
        }

        public Builder last(String lastName){
            this.lastName=lastName;
            return this;
        }

        public Builder address(Address address){
            this.address=address;
            return this;
        }

        public Builder copy(Planner planner){
            this.id=planner.id;
            this.firstName=planner.firstName;
            this.lastName=planner.lastName;
            this.address=planner.address;

            return this;
        }
        public Planner build(){
            return new Planner(this);
        }
    }
}