package ru.job4j.depthofmarket;

/**
 * поле type, если заявку выставить,
 * то значение true
 * если снять , то false
 *
 * поле action
 * bid = true
 * ask = false
 *
 * идея. сделать интерфейсы Type, Action
 *
 */

public class Item {
    private int id;
    private String book;
    private boolean type;
    private boolean action;
    private int price;
    private int volume;

    public Item(int id, String book, boolean type,
    boolean action, int price, int volume) {
        this.id = id;
        this.book = book;
        this.type = type;
        this.action = action;
        this.price = price;
        this.volume = volume;
    }
    public Item() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
