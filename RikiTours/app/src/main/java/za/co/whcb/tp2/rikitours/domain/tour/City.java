package za.co.whcb.tp2.rikitours.domain.tour;
/**
 * Created by Encore on 9/17/2016.
 */
public class  City{
    private Long id;
    private String name;
    private String description;

    public City(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
    }
    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder{
        private Long id;
        private String name;
        private String description;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder description(String description){
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