package za.co.whcb.tp2.rikitours.domain.tour;
import za.co.whcb.tp2.rikitours.domain.tour.City;
/**
 * Created by Encore on 9/17/2016.
 */
public class Country{
    private Long id;
	private String name;
	private City city;
	private String countryCode;
	private String flagImage;

    public Country(Builder builder){
        this.id=builder.id;
        this.name=builder.name;
        this.city=builder.city;
        this.countryCode=builder.countryCode;
        this.flagImage=builder.flagImage;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public City getCity(){
        return city;
    }

    public String getCountryCode(){
        return countryCode;
    }

    public String getFlagImage(){
        return flagImage;
    }

    public static class Builder{
        Long id, String name,City city,String countryCode,String flagImage;

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder name(String name){
            this.name=name;
            return  this;
        }

        public Builder city(City city){
            this.city=city;
            return this;
        }

        public Builder code(String countryCode){
            this.countryCode=countryCode;
            return this;
        }

        public Builder flag(String flagImage){
            this.flagImage=flagImage;
            return this;
        }

        public Builder copy(Country country){
            this.id=country.id;
            this.name=country.name;
            this.city=country.city;
            this.countryCode=country.countryCode;
            this.flagImage=country.flagImage;

            return this;
        }
        public Planner build(){
            return new Planner(this);
        }

    }
}