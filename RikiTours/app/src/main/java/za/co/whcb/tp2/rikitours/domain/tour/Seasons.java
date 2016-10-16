package za.co.whcb.tp2.rikitours.domain.tour;
/**
 * Created by Encore on 9/17/2016.
 */
public class Seasons{
    private Long id;
    private String name;
    private SeasonDescription description;

    public Seasons(Builder builder){
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

    public SeasonDescription getDescription() {
        return description;
    }

    public static class Builder{
        private Long id;
        private String name;
        private SeasonDescription description;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder description(SeasonDescription description){
            this.description = description;
            return this;
        }


        public Builder copy(Seasons seasons){
            this.id=seasons.id;
            this.name=seasons.name;
            this.description = seasons.description;

            return this;
        }
        public Seasons build(){
            return new Seasons(this);
        }

    }
}