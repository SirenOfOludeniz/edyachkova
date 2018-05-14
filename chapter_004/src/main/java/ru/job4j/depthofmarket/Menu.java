package ru.job4j.depthofmarket;

import ru.job4j.tree.Tree;

import javax.print.DocFlavor;
import java.util.*;

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

    /**
     * этот для консоли
     * @param book
     */
    public void visual(String book) {
        Dom dom = actionSystem.findDom(book);
        System.out.printf("|%-7s|%-7s|%-7s", "Покупка", "Цена", "Продажа");
       // System.out.println();
        for (Item item : mergeItem3(dom.ask).values()) {
            itemTable(item);
        }
        System.out.println();
        for (Item item : mergeItem3(dom.bid).values()) {
            itemTable(item);
        }


    }

    /**
     * этот для вывода в тесте
     * @param book
     * @param bid
     * @param ask
     */
    public void visual(String book, TreeMap<Integer, Item> bid, TreeMap<Integer, Item> ask) {

        System.out.printf("|%-7s|%-7s|%-7s", "Покупка", "Цена", "Продажа");
        System.out.println();

        for (Item item : mergeItem3(ask).values()) {

            itemTable(item);
        }
        System.out.println();

       for (Item item : mergeItem3(bid).values()) {
            itemTable(item);
        }
    }

    public TreeMap<Integer, Item> mergeItem3(TreeMap<Integer, Item> tree) {
        TreeMap<Integer, Item> result = new TreeMap<>();
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Item> pair : tree.entrySet()) {
            set.add(pair.getValue().getPrice());
        }

      //  System.out.println(set);

        Item current = new Item();


        for (Integer price : set) {
            int volumeSum = 0;
            for (Map.Entry<Integer, Item> pair : tree.entrySet()) {
                if (price == pair.getValue().getPrice()) {
                    volumeSum += pair.getValue().getVolume();
                    current = pair.getValue();
                }
            }
            current.setVolume(volumeSum);
            result.put(current.getId(), current);
        }
        return result;
    }

    public void itemTable(Item item) {

        if (item.isAction()) { //bid
            System.out.println("---------------------------------------------");
            System.out.printf("|%-7d|%-7d|%-7s", item.getVolume(), item.getPrice(), "");
            System.out.println();


        } else {
            System.out.println("---------------------------------------------");
            System.out.printf("|%-7s|%-7d|%-7d", "", item.getPrice(), item.getVolume());
            System.out.println();

        }

    }




}









