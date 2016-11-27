package za.co.whcb.tp2.rikitours.domain.tour;
/**
 * Created by Encore on 9/17/2016.
 */
public class  City{
    private long id;
    private String name;
    private CityDescription description;

    public City(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
    }
    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public CityDescription getDescription() {
        return description;
    }

    public static class Builder{
        private long id;
        private String name;
        private CityDescription description;

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder description(CityDescription description){
            this.description = description;
            return this;
        }


        public Builder copy(City city){
            this.id=city.id;
            this.name=city.name;
            this.description = city.description;

            return this;
        }
        public City build(){
            return new City(this);
        }
    }
}