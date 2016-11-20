package za.co.whcb.tp2.rikitours.domain.tour;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CityDescription {
    private long id;

    private String description;
    private Country country;



    public CityDescription(Builder builder){
        this.id = builder.id;
        this.description = builder.description;
        this.country = builder.country;
    }

    public String getDescription() {
        return description;
    }

    public Country getCountry() {
        return country;
    }


    public long getId() {
        return id;
    }

    public static class Builder{
        private long id;
        private String description;
        private Country country;


        public Builder id(long id){
            this.id=id;
            return this;
        }



        public Builder description(String description){
            this.description=description;
            return this;
        }

        public Builder country(Country country){
            this.country = country;
            return this;
        }


        public Builder copy(CityDescription city){
            this.id = city.id;
           this.country = city.country;
            this.description = city.description;
            return this;
        }
        public CityDescription build(){
            return new CityDescription(this);
        }
    }
}
