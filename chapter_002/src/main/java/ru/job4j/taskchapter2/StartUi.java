package ru.job4j.taskchapter2;

import ru.job4j.start.StartUI;

import java.util.Iterator;

public class StartUi {
    private Input input;
    private static final int EXIT = 0;
    private static final int ADD = 1;
    private static final int FINDALL = 1;
    private static final int UPDATE = 1;
    private static final int DELETE = 1;
    private static final int FINDBYID = 1;
    private static final int FINDBYNAME = 1;


    public StartUi(Input input) {
        this.input = input;
    }
    public StartUi() {

    }


    public void menu() {

        String word = input.action("Введите 0, если хотите закрыть программу");
       long Datecreate = Integer.parseInt(word);


        while(!(word.equals(EXIT))) {
            //тут надо применять Consileinput input = new Consoleinput();?
            Tracker tracker = new Tracker();
            Item item = new Item(input.action("Введите id"), input.action("Введите name"),
                    input.action("Введите описание"), Datecreate,
            input.action("Введите комментарий")); //вот тут надо, чтоб полозователь заполнил поля объекта Item

            System.out.println("Выберите пункт меню");

            System.out.println("0. Add new Item");
            System.out.println("1. Show all items");
            System.out.println("2. Edit item");
            System.out.println("3. Delete item");
            System.out.println("4. Find item by Id");
            System.out.println("5. Find items by name");
            System.out.println("6. Exit Program");


            String action = input.action("Введите цифру нужного пункта");

            if (action == "0") {
                tracker.add(item);
            } else if (action == "1") {
                tracker.findAll();
            } else if (action == "2") {
                tracker.update(item);
            } else if (action == "3") {
                tracker.delete(item);
            } else if (action == "4") {
                tracker.findById(input.action("Введите id"));

            } else if (action == "5") {
                tracker.findByName(input.action("Введите name"));
            } else if (action == "6") {
                //ну и как закрыть программу? в смысле как выйти из нее?
            }


        }
    }


    public static void main(String[] args) {
        StartUi start = new StartUi();
        start.menu();



            // тут надо как-то menu вызывать, но я не знаю как, проблемы со Static

        //как выйти из программы?





    }
}


























