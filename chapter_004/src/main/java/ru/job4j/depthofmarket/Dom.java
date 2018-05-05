package ru.job4j.depthofmarket;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Сам стакан.
 * Для каждого эмитента - один стакан.
 *
 * Issuer - название эмитента
 *
 * Чтобы добавить первую заявку или с 0
 * или заявку эмитента, которого еще нет,
 * нужно создать стакан под конкретного эмитента
 *
 *
 * Integer - ключ, поле Item - int id
 *
 * оба списка относятся к одному эммитенту
 */

public class Dom {
    public String book;
    TreeMap<Integer,Item> ask = new TreeMap<>(Collections.reverseOrder()); // или их лучше в конструкторе проинициализировать
    TreeMap<Integer,Item> bid = new TreeMap<>(Collections.reverseOrder()); // вообще, есть ли разница в способах инициазации

    public Dom(String book) {
        this.book = book;
    }

}
