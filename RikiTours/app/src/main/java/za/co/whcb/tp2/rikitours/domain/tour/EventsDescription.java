package za.co.whcb.tp2.rikitours.domain.tour;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class EventsDescription {
    private String description;
    private String start;String end;
    private City city;

    public EventsDescription(Builder builder){
        this.description=builder.description;
        this.start=builder.start;
        this.end=builder.end;
        this.city=builder.city;
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

    public City getCity(){
        return city;
    }

    public static class Builder{
        private String description, start, end;
        private City city;


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

        public Builder copy(EventsDescription events){
            this.description=events.description;
            this.start=events.start;
            this.end=events.end;
            this.city=events.city;

            return this;
        }
        public EventsDescription build(){
            return new EventsDescription(this);
        }
    }
}
