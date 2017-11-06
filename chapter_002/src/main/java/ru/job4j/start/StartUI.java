package ru.job4j.start;

import ru.job4j.models.*;

public class StartUI {
    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        //ConsoleInput input = new ConsoleInput();
        String name = input.ask("Please enter the task`s name: ");
        //Item item12 = new Item();
        Tracker tracker = new Tracker();
        //tracker.add(item12);
        tracker.add(new Task(name, "description"));
        for (Item item : tracker.getAll()) {
            System.out.println(item.getName());

        }
    }

    public static void main(String[] args) {
        //new StartUI(new StubInput(new String[] {"create stub task"})).init();
        Input input = new ConsoleInput();
        //Input input = new StubInput(new String[] {"create stub task"});
        new StartUI(input).init();
    }
}


















