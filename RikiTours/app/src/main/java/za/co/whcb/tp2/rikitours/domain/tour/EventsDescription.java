package za.co.whcb.tp2.rikitours.domain.tour;

/**
 * Created by Shaun Mesias on 2016/10/02.
 */
public class EventsDescription {
    private Long id;
    private String description;
    private String start;
    private String end;
    private City city;

    public EventsDescription(Builder builder){
        this.description=builder.description;
        this.start=builder.start;
        this.end=builder.end;
        this.city=builder.city;
    }
    public Long getId() {
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

    public City getCity(){
        return city;
    }

    public static class Builder{
        Long id;
        private String description, start, end;
        private City city;

        public Builder id(Long id){
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

        public Builder city(City city){
            this.city=city;
            return this;
        }

        public Builder copy(EventsDescription events){
            this.id=events.id;
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
