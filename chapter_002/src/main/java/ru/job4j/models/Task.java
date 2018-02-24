package ru.job4j.models;

public class Task extends Item {
    public Task(String name, String desk) {
        this.name = name;
        this.description = desk;
    }
    public String calculatePrice() {
        return "100%";
    }

}
