package ru.job4j.taskchapter2;

import ru.job4j.start.StartUI;

import java.util.Iterator;

public class StartUi {
    private Input input;
    private static final int EXIT = 0;


    public StartUi(Input input) {
        this.input = input;
    }


    public void menu() {

        //тут надо применять Consileinput input = new Consoleinput();?
        Tracker tracker = new Tracker();
        Item item = new Item(); //вот тут надо, чтоб полозователь заполнил поля объекта Item

        System.out.println("Выберите пункт меню");

        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");


        String action = input.action("Введите цифру нужного пункта");

        if(action == "0") {
            tracker.add(item);
        }
        else if(action == "1") {
            tracker.findAll();
        } else if (action == "2") {
            tracker.update(item);
        }
        else if (action == "3") {
            tracker.delete(item);
        }
        else if(action == "4") {
            tracker.findById(item.getId());//вот тут надо, чтоб пользователь ввел id

        }
        else if(action == "5") {
            tracker.findByName(item.getName());//вот тут надо, чтоб пользователь ввел name
        }
        else if(action == "6") {
            //ну и как закрыть программу? в смысле как выйти из нее?
        }



    }


    public static void main(String[] args) {


        ConsoleInput input = new ConsoleInput();
        String userinput = input.action("Для выхода из программы введите 0");

        while (!(userinput.equals(EXIT))) {
            // тут надо как-то вечно menu вызывать, но я не знаю как, проблемы со Static
        }
        //как выйти из программы?





    }
}


























