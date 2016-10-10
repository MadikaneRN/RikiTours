package za.co.whcb.tp2.rikitours.domain.tour;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class CityDescription {
    private Long id;
    private String suburb, nation;

    public CityDescription(Builder builder){
        this.id = builder.id;
        this.suburb = builder.suburb;
        this.nation = builder.nation;
    }

    public Long getId() {
        return id;
    }

    public String getSuburb(){
        return suburb;
    }

    public String getNation() {
        return nation;
    }

    public static class Builder{
        private Long id;
        private String suburb, nation;

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder suburb(String suburb){
            this.suburb=suburb;
            return this;
        }

        public Builder nation(String nation){
            this.nation=nation;
            return this;
        }

        public Builder copy(CityDescription city){
            this.id = city.id;
            this.suburb=city.suburb;
            this.nation = city.nation;

            return this;
        }
        public CityDescription build(){
            return new CityDescription(this);
        }
    }
}
