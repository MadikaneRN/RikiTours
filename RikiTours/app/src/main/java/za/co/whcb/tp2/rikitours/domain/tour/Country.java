package za.co.whcb.tp2.rikitours.domain.tour;
import za.co.whcb.tp2.rikitours.domain.tour.City;
/**
 * Created by Encore on 9/17/2016.
 */
public class Country{
    private Long id;
	private String name;
    private CountryDescription countryDescription;

    public Country(Builder builder){
        this.id=builder.id;
        this.name=builder.name;
        this.countryDescription = builder.countryDescription;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public CountryDescription getCountryDescription() {
        return countryDescription;
    }

    public static class Builder{
        private Long id;
        private String name;
        private CountryDescription countryDescription;

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder name(String name){
            this.name=name;
            return  this;
        }

        public Builder countryDescription(CountryDescription countryDescription){
            this.countryDescription=countryDescription;
            return  this;
        }

        public Builder copy(Country country){
            this.id=country.id;
            this.name=country.name;
            this.countryDescription = country.countryDescription;

            return this;
        }
        public Country build(){
            return new Country(this);
        }

    }
}