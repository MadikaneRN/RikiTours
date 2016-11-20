package za.co.whcb.tp2.rikitours.domain.tour;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class EventsDescription {
    private long id;
    private String description;
    private String start;
    private String end;
    private Country country;

    public EventsDescription(Builder builder){
        this.description=builder.description;
        this.start=builder.start;
        this.end=builder.end;
        this.country=builder.country;
    }
    public long getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }

    public String getStart(){
        return start;
    }

    public String getEnd(){
        return end;
    }

    public Country getCountry(){
        return country;
    }

    public static class Builder{
        long id;
        private String description, start, end;
        private Country country;

        public Builder id(long id){
            this.id=id;
            return this;
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

        public Builder country(Country country){
            this.country=country;
            return this;
        }

        public Builder copy(EventsDescription events){
            this.id=events.id;
            this.description=events.description;
            this.start=events.start;
            this.end=events.end;
            this.country=events.country;

            return this;
        }
        public EventsDescription build(){
            return new EventsDescription(this);
        }
    }
}
