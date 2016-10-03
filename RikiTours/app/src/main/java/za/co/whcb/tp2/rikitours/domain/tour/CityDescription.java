package za.co.whcb.tp2.rikitours.domain.tour;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CityDescription {
    private String suburb, nation;

    public CityDescription(Builder builder){
        this.suburb = builder.suburb;
        this.nation = builder.nation;
    }

    public String getSuburb(){
        return suburb;
    }

    public String getNation() {
        return nation;
    }

    public static class Builder{
        private String suburb, nation;


        public Builder suburb(String suburb){
            this.suburb=suburb;
            return this;
        }

        public Builder nation(String nation){
            this.nation=nation;
            return this;
        }

        public Builder copy(CityDescription city){
            this.suburb=city.suburb;
            this.nation = city.nation;

            return this;
        }
        public CityDescription build(){
            return new CityDescription(this);
        }
    }
}
