package ru.job4j.taskchapter2;

import ru.job4j.start.StartUI;

import java.util.Iterator;

public class StartUi {
    private Input input;
   int[] ranges = new int[] {1, 2, 5}; //как сделать, чтобы тут были значения из MenuTracker? и зачем это надо? вообще не понятно
    private static final int EXIT = 0;
    private static final int ADD = 1;
    private static final int FINDALL = 2;
    private static final int UPDATE = 3;
    private static final int DELETE = 4;
    private static final int FINDBYID = 5;
    private static final int FINDBYNAME = 6;
    Tracker tracker5;

    public StartUi(Input input, Tracker tracker) {
        this.input = input;
        this.tracker5 = tracker;
    }

    public StartUi(Input input) {
        this.input = input;
    }

    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.action("select: ", ranges)); // здесь применен новый ask(String question, int[] ranges)
        } while (! "y".equals(this.input.action("Exit?(y)"))); }

    //public StartUi() {

    //}

   /* public void init() { //прежний init
        Tracker tracker = new Tracker();
        MenuTracker menu3 = new MenuTracker(this.input, tracker);
        menu3.fillActions();
        do {
            menu3.show();
            int key = Integer.valueOf(input.action("Select: "));
            menu3.select(key);
        } while (!"y".equals(this.input.action("Exit?")));


    }*/


    public void menu(Tracker tracker) {


       boolean exit = false;
       do {

            System.out.println("Выберите пункт меню");

            System.out.println("1. Add new Item");
            System.out.println("2. Show all items");
            System.out.println("3. Edit item");
            System.out.println("4. Delete item");
            System.out.println("5. Find item by Id");
            System.out.println("6. Find items by name");
            System.out.println("0. Exit Program");


            int actionnums = Integer.parseInt(input.action("Введите цифру нужного пункта")); // здесь выбрасывает исключение

            if (actionnums == ADD) {
                Item item1 = new Item(input.action("Введите id"), input.action("Введите name"),
                        input.action("Введите описание"), input.inputdate("Введите дату создания"),
                        input.action("Введите комментарий"));
                tracker.add(item1);
            } else if (actionnums == FINDALL) {

                for (int i = 0; i < tracker.findAll().length; i++) {
                    itemTable(tracker.findAll()[i]);
                }


               tracker.findAll();
            } else if (actionnums == UPDATE) {
                System.out.println("Для редактирования заявки, заполните данные новой заявки, которая заменит"
                        + "старую заявку");

                Item newitem = new Item(input.action("Введите id"), input.action("Введите name"),
                        input.action("Введите описание"), input.inputdate("Введите дату создания"),
                        input.action("Введите комментарий"));


                newitem.setId(tracker.findById(input.action("Введите id редактируемой заявки")).getId());

                tracker.update(newitem);


            } else if (actionnums == DELETE) {

                tracker.delete(tracker.findById(input.action("Введите id удаляемой заявки")));

            } else if (actionnums == FINDBYID) {

                itemTable(tracker.findById(input.action("Введите id")));

            } else if (actionnums == FINDBYNAME) {

                for (int i = 0; i < tracker.findByName(input.action("Введите name заявок, которые ищете")).length; i++) {
                    itemTable(tracker.findByName(input.action("Введите тоже самое"))[i]);

                }

            } else if (actionnums == EXIT) {

                exit = true;
                continue;

            }
        }
        while (!exit);
    }

    public void itemTable(Item item) {
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("|%-5s|%-11s|%-30s|%-10s|%-30s|%n", "Id", "Name", "Description", "Date", "Comment");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("|%-5s|%-11s|%-30s|%-10d|%-30s|%n", item.getId(), item.getName(), item.getDescription(), item.getDatecreation(), item.getKomment());
        System.out.println("--------------------------------------------------------------------------------------------");
    }



    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        //Item item = new Item();
        Input input = new ValidateInput();
        StartUi start = new StartUi(input);
        start.menu(tracker);






    }
}


























