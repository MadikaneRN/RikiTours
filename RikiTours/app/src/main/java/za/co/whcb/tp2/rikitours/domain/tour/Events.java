package za.co.whcb.tp2.rikitours.domain.tour;

import za.co.whcb.tp2.rikitours.domain.tour.City;
/**
 * Created by Encore on 9/17/2016.
 */
public class Events{
    private Long id, String name,String description,String start,String end,City city;

    public Events(Builder builder){
        this.id=builder.id;
        this.name=builder.name;
        this.description=builder.description;
        this.start=builder.start;
        this.end=builder.end;
        this.city=builder.city;
    }
    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription() {
        return description
    }

    public String getStart(){
        return start;
    }

    public String getEnd(){
        return end;
    }

    public City getCity(){
        return city;
    }
    public static Builder{
        Long id, String name,String description,String start,String end,City city;

        public Builder id (Long id){
           this.id=id;
        return this;
        }

        public Builder name(String name){
            this.name=name;
            return this
        }

        public Builder description(String description){
            this.description=description;
            return this;
        }

        public Builder start(String start){
            this.start=start;
            return  this;
        }

        public Builder end(String end){
            this.end=end;
            return this;
        }

        public Builder city(City city){
            this.city=city;
            return this;
        }

    public Builder copy(Events events){
        this.id=events.id;
        this.name=name;
        this.description=events.description;
        this.start=events.start;
        this.end=events.end;
        this.city=events.city;

        return this;
    }
    public Events build(){
        return new Events(this);
    }
    }
}