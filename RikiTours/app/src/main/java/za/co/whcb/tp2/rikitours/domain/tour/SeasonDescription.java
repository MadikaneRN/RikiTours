package za.co.whcb.tp2.rikitours.domain.tour;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class SeasonDescription {
    private String	description;
    private int numberOfSeason;

    public SeasonDescription(Builder builder){
        this.description = builder.description;
        this.numberOfSeason = builder.numberOfSeason;
    }


    public String getDescription() {
        return description;
    }

    public int getNumberOfSeason(){
        return numberOfSeason;
    }

    public static class Builder{
        private Long id;
        private String name, description;
        //to be checked
        private int numberOfSeason;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder description(String description){
            this.description=description;
            return this;
        }

        public Builder number(int numberOfSeason){
            this.numberOfSeason=numberOfSeason;
            return this;
        }

        public Builder copy(SeasonDescription seasons){
            this.numberOfSeason=seasons.numberOfSeason;
            this.description=seasons.description;

            return this;
        }
        public SeasonDescription build(){
            return new SeasonDescription(this);
        }

    }
}
