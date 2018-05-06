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
        Dom dom = actionSystem.findDom(book);
        System.out.printf("|%-7s|%-7s|%-7s", "Покупка", "Цена", "Продажа");
        System.out.println();
        for (Item item : dom.ask.values()) {

            itemTable(item);
        }
        System.out.println();
        for (Item item : dom.bid.values()) {
            itemTable(item);
        }

    }

    public void itemTable(Item item) {

        if (item.isAction()) { //bid
            System.out.println("---------------------------------------------");
            System.out.printf("|%-7d|%-7d|%-7s", item.getVolume(), item.getPrice(), "");


        } else {
            System.out.println("---------------------------------------------");
            System.out.printf("|%-7s|%-7d|%-7d", "", item.getPrice(), item.getVolume());

        }

    }




}









