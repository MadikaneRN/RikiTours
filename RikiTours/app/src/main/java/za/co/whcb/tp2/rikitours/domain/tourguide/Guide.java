package za.co.whcb.tp2.rikitours.domain.tourguide;

import za.co.whcb.tp2.rikitours.domain.Person;

/**
 * Created by berka on 9/17/2016.
 */
public class Guide implements Person {
    private Long id;
    private String name;
    private String surname;
    private String cell;
    private String email;

    public Guide() {
    }

    public Guide(Builder builder){
        this.id=builder.id;
        this.name=builder.name;
        this.surname=builder.surname;
        this.cell=builder.cell;
        this.email=builder.email;
    }

    @Override
    public long getId() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCell() {
        return cell;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder{
        private Long id;
        private String name;
        private String surname;
        private String cell;
        private String email;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }
        public Builder cell(String cell) {
            this.name = name;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder copy(Guide guide){
            this.id=guide.id;
            this.name =guide.name;
            this.surname = guide.surname;
            this.cell = guide.cell;
            this.email = guide.email;

            return this;
        }
        public Guide build(){
            return new Guide(this);
        }
    }
}

