package ru.job4j.map_sort;

public class UserM implements Comparable<UserM> {
    private String name;
    private int age;
    public UserM() {

    }
    public UserM(int age) {
        this.age = age;
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


   /* @Override
    public int compareTo(UserM o) {
        return this.name.compareTo(o.name);
    }*/

    /*@Override
    public int compareTo(Object o) {
        return 0;
    }*/

}
