package ru.job4j.taskchapter2;

import ru.job4j.start.StartUI;

import java.util.Iterator;

public class StartUi {
    private Input input;
    private static final int EXIT = 0;
    private static final int ADD = 1;
    private static final int FINDALL = 2;
    private static final int UPDATE = 3;
    private static final int DELETE = 4;
    private static final int FINDBYID = 5;
    private static final int FINDBYNAME = 6;


    public StartUi(Input input) {
        this.input = input;
    }
    public StartUi() {

    }


    public void menu() {

       // String word = input.action("Введите 0, если хотите закрыть программу");
       //long Datecreate = Long.parseLong(word);


       boolean exit = false;
       do{

            //тут надо применять Consileinput input = new Consoleinput();?
            Tracker tracker = new Tracker();
            Item item =  new Item();
            /*Item item = new Item(input.action("Введите id"), input.action("Введите name"),
                    input.action("Введите описание"), 7,
            input.action("Введите комментарий"));*/

            System.out.println("Выберите пункт меню");

            System.out.println("1. Add new Item");
            System.out.println("2. Show all items");
            System.out.println("3. Edit item");
            System.out.println("4. Delete item");
            System.out.println("5. Find item by Id");
            System.out.println("6. Find items by name");
            System.out.println("0. Exit Program");


            String actionnumsd = input.action("Введите цифру нужного пункта");
            int actionnums = Integer.parseInt(input.action("Введите цифру нужного пункта"));

            if (actionnums == ADD) {
                Item item1 = new Item(input.action("Введите id"), input.action("Введите name"),
                        input.action("Введите описание"), 7,
                        input.action("Введите комментарий"));
                tracker.add(item);
            } else if (actionnums == FINDALL) {
                tracker.findAll();
            } else if (actionnums == UPDATE) {
                tracker.update(item);
            } else if (actionnums == DELETE) {
                tracker.delete(item);
            } else if (actionnums == FINDBYID) {
                tracker.findById(input.action("Введите id"));

            } else if (actionnums == FINDBYNAME) {
                tracker.findByName(input.action("Введите name"));
            } else if (actionnums == EXIT) {

                exit = true;
                continue;

            }
        }
        while (!exit);
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        StartUi start = new StartUi(input);
        start.menu();



            // тут надо как-то menu вызывать, но я не знаю как, проблемы со Static

        //как выйти из программы?





    }
}


























