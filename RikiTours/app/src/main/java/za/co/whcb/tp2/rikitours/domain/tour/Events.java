package za.co.whcb.tp2.rikitours.domain.tour;

import za.co.whcb.tp2.rikitours.domain.tour.City;
/**
 * Created by Encore on 9/17/2016.
 */
public class Events{
    private long id;
	private String name;
    private EventsDescription description;

    public Events(Builder builder){
        this.id=builder.id;
        this.name=builder.name;
        this.description = builder.description;
    }
    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public EventsDescription getDescription() {
        return description;
    }

    public static class Builder{
        private long id;
        private String name;
        private EventsDescription description;

        public Builder id (Long id){
           this.id=id;
        return this;
        }

        public Builder name(String name){
            this.name=name;
            return this;
        }

        public Builder description(EventsDescription description){
            this.description=description;
            return this;
        }


    public Builder copy(Events events){
        this.id=events.id;
        this.name=events.name;
        this.description = events.description;

        return this;
    }
    public Events build(){
        return new Events(this);
    }
    }
}