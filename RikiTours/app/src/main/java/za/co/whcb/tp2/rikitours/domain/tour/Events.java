package za.co.whcb.tp2.rikitours.domain.tour;

import za.co.whcb.tp2.rikitours.domain.gallery.RikiImage;
import za.co.whcb.tp2.rikitours.domain.tour.City;
/**
 * Created by Encore on 9/17/2016.
 */
public class Events{
    private Long id;
	private String name;
    private EventsDescription description;
    private RikiImage image;

    public Events(Builder builder){
        this.id=builder.id;
        this.name=builder.name;
        this.description = builder.description;
        this.image=builder.image;
    }
    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public EventsDescription getDescription() {
        return description;
    }

    public RikiImage getImage() {
        return image;
    }

    public static class Builder{
        private Long id;
        private String name;
        private EventsDescription description;
        private RikiImage image;

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

        public Builder image(RikiImage image){
            this.image=image;
            return this;
        }


    public Builder copy(Events events){
        this.id=events.id;
        this.name=events.name;
        this.description = events.description;
        this.image=events.image;
        return this;
    }
    public Events build(){
        return new Events(this);
    }
    }
}