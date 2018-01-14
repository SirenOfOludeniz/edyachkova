package ru.job4j.map_sort;

public class UserM implements Comparable{
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
    public int compareTo(Object o) {
        return 0;
    }
}
