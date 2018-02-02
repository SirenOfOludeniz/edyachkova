package ru.job4j.mapsort;

import java.util.Comparator;

public class UserM implements Comparable<UserM>, Comparator<UserM> {
    private String name;
    private int age;
    public UserM() {

    }
    public UserM(int age) {
        this.age = age;
    }
    public UserM(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserM{" +
                "age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(UserM o) {
        return this.age - o.age;
    }

    @Override
    public int compare(UserM o1, UserM o2) {
        return 0;
    }


    }


