package za.co.whcb.tp2.rikitours.domain.rental;

/**
 * Created by berka on 9/17/2016.
 */
public class Car {
    private String name, type, color, id;
    private int numberOfSeat, year;

    public Car() {
    }

    public Car(String name, String type, int numberOfSeat, int year, String color) {
        this.name = name;
        this.type = type;
        this.numberOfSeat = numberOfSeat;
        this.year = year;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
