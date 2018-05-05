package ru.job4j.depthofmarket;

import javax.print.DocFlavor;

public class Menu {
    ActionSystem actionSystem;
    UserInput input;

    public Menu() {
        this.actionSystem = new ActionSystem();
        this.input = new UserInput();

    }

    public void select(int key) {
        if (key == 1) {
            input();
        }
        if (key == 2) {
            visual(input.actionString("Введите назваие эмитента"));
        }
    }

    public void input() {
        int id = input.actionInt("Введите id заявки");
        String book = input.actionString("Введите эмитента");
        boolean type = Boolean.parseBoolean(input.actionString("Введите: true - добавить заявку, false - снять"));
        boolean action = Boolean.parseBoolean(input.actionString("Введите: true - покупка (bid), false - продажа (ask)"));
        int price = input.actionInt("Введите цену");
        int volume = input.actionInt("Введите количество акций");

        Item item = new Item(id, book, type, action, price, volume);

        actionSystem.inputItem(item, actionSystem.defineBook(item));
    }

    public void visual(String book) {
        for (Dom dom : actionSystem.doms) {
            if (dom.book.equals(book)) {
                System.out.println(dom.ask);
                System.out.println(dom.bid);
            }
            else System.out.println("Заявок с таким эмитентом нет");
        }

    }




}
