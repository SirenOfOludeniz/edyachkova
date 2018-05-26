package ru.job4j.tree;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class TreeTest {
    public static final class User implements Comparable<User>{
        public String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(User o) {
            return this.name.compareTo(o.name);
        }
    }
    @Test
    public void add() {
        TreeSet<User> users = new TreeSet<>();
        users.add(new User("petr"));
    }
    @Test
    public void add2() {
        TreeSet<User> users = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        users.add(new User("petr"));
        users.add(new User("Arsentev"));
    }
}
