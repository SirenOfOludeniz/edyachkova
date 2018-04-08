package ru.job4j.testtask;

import java.util.Objects;

public class User {
    private String name;
    private String passport;

    public User() {

    }
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassport() {
        return passport;
    }
    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        //todo тут точно == а не equals?
        return passport == user.passport && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, passport);
    }
}
