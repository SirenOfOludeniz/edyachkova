package ru.job4j.start;

import ru.job4j.models.*;

public class StartUI {
    public static void main(String[] args) {
        Item item12 = new Item();
        Tracker tracker = new Tracker();
        tracker.add(item12);
        for (Item item : tracker.getAll()) {
            System.out.println(item.getName());

        }
    }
}
