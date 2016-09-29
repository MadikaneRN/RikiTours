package za.co.whcb.tp2.rikitours.domain.tour;
/**
 * Created by Encore on 9/17/2016.
 */
public class City{
    private Long id;
    private String name,suburb;

    public City(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.suburb = builder.suburb;
    }
    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSuburb(){
        return suburb;
    }

    public static class Builder{
        private Long id;
        private String name,suburb;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder suburb(String suburb){
            this.suburb=suburb;
            return this;
        }

        public Builder copy(City city){
            this.id=city.id;
            this.name=city.name;
            this.suburb=city.suburb;

            return this;
        }
        public City build(){
            return new City(this);
        }
    }
}