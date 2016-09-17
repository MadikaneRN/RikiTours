package za.co.whcb.tp2.rikitours.domain.guide;

import za.co.whcb.tp2.rikitours.domain.Person;

/**
 * Created by kelly on 9/17/2016.
 */
public class Guide implements Person {
    private  String name, surname, cell, email;

    public Guide() {
    }

    public Guide(String name, String surname, String cell, String email) {
        this.name = name;
        this.surname = surname;
        this.cell = cell;
        this.email = email;
    }

    @Override
    public int getId() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
