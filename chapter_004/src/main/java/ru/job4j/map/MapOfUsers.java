package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapOfUsers {
    public void addEqualFieldUsers() {
        Map<User, Object> map = new HashMap<>();
        User ivan = new User("Ivan", new GregorianCalendar(1994, Calendar.JANUARY, 22));
        User doubleIvan = new User("Ivan", new GregorianCalendar(1994, Calendar.JANUARY, 22));
        map.put(ivan, "Ivan Unique");
        map.put(doubleIvan, "Ivan Copy");
        System.out.println(map);
    }
}
