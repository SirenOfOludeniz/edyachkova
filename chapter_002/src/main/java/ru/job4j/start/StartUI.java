package ru.job4j.start;

import ru.job4j.models.*;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Task("first task", "first desc"));
        for(Item item : tracker.getAll()) {
            System.out.println(item.getName());

        }
    }
}
