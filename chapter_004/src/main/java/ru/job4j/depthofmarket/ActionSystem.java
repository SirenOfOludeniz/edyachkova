package ru.job4j.depthofmarket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Если эмитент заявки уже существует, то добавляем
 * в стакан этого эмитента
 *
 * Как идея: Если поступившая заявка содержит неизвестного эмитента,
 *то для него создаётся новый стакан
 *
 */



public class ActionSystem {

    public ArrayList<Dom> doms;

    public ActionSystem(Dom doms) {
       this.doms = new ArrayList<>();
   }

    /**
     * если не нашли эмитента, создаем
     * новый стакан для заявки с новым эмитентом
     * @param item
     * @return
     */

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
    public void inputItem(Item item) {
        if (item.isType()) { //true - заявка на добавление
            if (item.isAction()) { //true - тип заявки bid
                defineBook(item).bid.put(item.getId(), item);
            }
            else {
                defineBook(item).ask.put(item.getId(), item);
            }
        }
        else {//удаляем заявку
            if (item.isAction()) { //из списка bid
                defineBook(item).bid.remove(item.getId());
            }
            else {
                defineBook(item).ask.remove(item.getId());
            }
        }

    }


    public Dom defineBook(Item item) {
        Dom result = null;
        for (Dom dom : this.doms) {
            if (dom.book.equals(item.getBook())) {
                result = dom;
            }
            else {
                result = createDom(item.getBook());
            }
        }
        return result;
    }

    public Dom createDom(String book) {
        return new Dom(book);
    }

    public TreeMap<Integer, Item> sortItems(HashMap<Integer, Item> map) {
       ItemComparator comparator = new ItemComparator(map);
        TreeMap<Integer, Item> tree = new TreeMap<Integer, Item>(comparator);
        tree.putAll(map);
        return tree;
    }


}
