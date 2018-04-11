package ru.job4j.map;

import java.util.Calendar;

public class User {
    String name;
    int children;
    Calendar birthday;
    public User(String name, Calendar birthday) {
        this.name = name;
        this.birthday = birthday;
    }
}
