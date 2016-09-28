package za.co.whcb.tp2.rikitours.domain.tour;
/**
 * Created by Encore on 9/17/2016.
 */
public class Seasons{
    private Long id, String name,String desription,int numberOfSeason;

    public Seasons(Builder builder){
        this.id=builder.id;
        this.name=builder.name;
        this.desription=builder.description;
        this.numberOfSeason=builder.numberOfSeason;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription() {
        return description
    }

    public String getNumberOfSeason(){
        return numberOfSeason;
    }

    public static class Builder{
        Long id, String name,String desription,int numberOfSeason;

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder name(String streetName){
            this.streetName=streetName;
            return this;
        }

        public Builder description(String numberOfSeason){
            this.numberOfSeason=numberOfSeason;
            return this;
        }

        public Builder number(int description){
            this.description=description;
            return this;
        }

        public Builder copy(Seasons seasons){
            this.id=seasons.id;
            this.streetName=seasons.streetName;
            this.numberOfSeason=seasons.numberOfSeason;
            this.description=seasons.description;

            return this;
        }
        public Seasons build(){
            return new Seasons(this);
        }

    }
}