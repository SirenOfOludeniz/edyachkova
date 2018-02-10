package ru.job4j.peerreview;

public class User implements Comparable<User> {
    private Integer id;
    private Integer age;
    private String name;
    private String city;
    public User() {
    }
    public User(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + '}';
    }
    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.getName());
    }
}
