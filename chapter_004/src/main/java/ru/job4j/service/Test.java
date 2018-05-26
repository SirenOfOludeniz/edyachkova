package ru.job4j.service;

import java.util.Hashtable;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {

        User first = new User("Vanya");
        User second = new User("Vanya");
        second = first;
        System.out.println(second == first);

        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "baton");

    }
}


class User {
    public String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

class Cow{
    public void printColor() {
        System.out.println("Я = белая");
    }
    public void printName() {
        System.out.println("Корова");
    }

}

class Whale extends Cow{
    public void printName() {
        System.out.println("Я - кит");
    }

}






















