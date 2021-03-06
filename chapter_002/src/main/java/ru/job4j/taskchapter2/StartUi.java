package ru.job4j.taskchapter2;

public class StartUi {
    private final Input input;
    private final Tracker tracker;

    public StartUi(final Input input, final Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        String exit;
        do {
            menu.show();
            menu.select(input.action("select: ", menu.range())); // здесь применен новый ask(String question, int[] ranges)
             exit = this.input.action("exit?");
            System.out.println("exit" + exit);
        } while (!"y".equals(exit)); }


    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ValidateInput();
        StartUi ui = new StartUi(input, tracker);
        ui.init();
    }
}


























