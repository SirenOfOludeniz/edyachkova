package ru.job4j.depthofmarket;

import ru.job4j.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Если эмитент заявки уже существует, то добавляем
 * в стакан этого эмитента
 * <p>
 * Как идея: Если поступившая заявка содержит неизвестного эмитента,
 * то для него создаётся новый стакан
 */


public class ActionSystem {

    public ArrayList<Dom> doms;

    public ActionSystem() {
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
     * <p>
     * поле action
     * bid = true
     * ask = false
     * <p>
     * идея. сделать интерфейсы Type, Action
     */
    public void inputItem(Item item, Dom dom) {

        if (item.isType()) {//add
            if (item.isAction()) {//bid
                addItem(item, dom.bid, dom);
            } else {//ask
                addItem(item, dom.ask, dom);
            }
        }
        if (!item.isType()) { //delete
            if (item.isAction()) {
                deleteItemById(dom.bid, item);
            } else {
                deleteItemById(dom.ask, item);
            }
        }
    }

    public void addItem(Item item, TreeMap<Integer, Item> tree, Dom dom) {
        Item aimItem;
        TreeMap<Integer, Item> resultTree;

        resultTree = item.isAction() ? dom.ask : dom.bid;

        if (!resultTree.isEmpty()) {
            if (item.isAction()) {
                aimItem = dom.ask.lastEntry().getValue();
            } else {
                aimItem = dom.bid.firstEntry().getValue();
            }
            if (aimItem.getPrice() <= item.getPrice()) {
                buySell(dom.ask, item, dom.bid);
            } else {
                tree.put(item.getId(), item);
            }
        }
        if (resultTree.isEmpty()) {
            tree.put(item.getId(), item);
        }

    }

    public Dom findDom(String book) {
        Dom result = Dom.EMPTY;
        for (Dom dom : this.doms) {
            if (dom.book.equals(book)) {
                result = dom;
            } else {
                System.out.println("Заявок с таким эмитентом еще нет");
            }
        }
        return result;
    }

    /**
     * удаление по цене может не подойти, если
     * есть в tree несколько заявок с одинаковой ценой
     * поэтому пока применен deleteItemById в inputItem().
     * <p>
     * но это в расчете на то, что в заявке на удаление
     * пользователь ОБЯЗАТЕЛЬНО введет то же id, что он ставил в
     * своей заявке на доавление до этого.
     *
     * @param tree
     * @param item
     */

    public void deleteItemByPrice(TreeMap<Integer, Item> tree, Item item) {
        {
            Item tmp = findItemByPrice(tree, item.getPrice());
            if (tmp.getVolume() > item.getVolume()) { // частичное удаление
                tree.get(tmp.getId()).setVolume(tmp.getVolume() - item.getVolume());
            } else { //полное удаление заявки
                tree.remove(tmp.getId());
            }
        }

    }


    public Item findItemByPrice(TreeMap<Integer, Item> tree, int price) {
        Item result = null;
        for (Map.Entry<Integer, Item> pair : tree.entrySet()) {
            if (pair.getValue().getPrice() == price) {
                result = pair.getValue();
            }
        }
        return result;
    }

    public void deleteItemById(TreeMap<Integer, Item> tree, Item item) {
        Item tmp = tree.get(item.getId());
        if (tmp.getVolume() > item.getVolume()) { //частичное удаление
            tree.get(item.getId()).setVolume(tmp.getVolume() - item.getVolume());
        } else { //полное удаление всей заявки
            tree.remove(item.getId());
        }
    }

    public Dom defineBook(Item item) {
        if (doms.isEmpty()) {
            doms.add(createDom(item.getBook()));
        }
        Dom result = null;
        for (Dom dom : this.doms) {
            if (dom.book.equals(item.getBook())) {
                result = dom;
            }
        }
        return result;
    }

    public Dom createDom(String book) {
        return new Dom(book);
    }

    /**
     * Action: bid , ask
     * bid - true (isAction())
     * ask - false (!isAction())
     * <p>
     * если заявка типа bid, то совмещаем её с подследней заявкой из дерева ask
     * если заявка типа ask, то совмещаем ее с первой заявкой из дерева bid
     *
     * @param
     * @param item
     */
    public void buySell(TreeMap<Integer, Item> ask, Item item, TreeMap<Integer, Item> bid) {

        Item aimItem;

        if (item.isAction()) {
            aimItem = ask.lastEntry().getValue();
        } else {
            aimItem = bid.firstEntry().getValue();
        }

        if (item.getVolume() > aimItem.getVolume()) {
            item.setVolume(item.getVolume() - aimItem.getVolume());
            if (item.isAction()) {
                bid.put(item.getId(), item);
                ask.remove(aimItem.getId());
            } else {
                ask.put(item.getId(), item);
                bid.remove(aimItem.getId());
            }

        } else if (item.getVolume() == aimItem.getVolume()) {
            ask.remove(aimItem.getId());
            bid.remove(item.getId());
        } else if (item.getVolume() < aimItem.getVolume()) {
            if (item.isAction()) {
                ask.lastEntry().getValue().setVolume(aimItem.getVolume() - item.getVolume());
            } else {
                bid.firstEntry().getValue().setVolume(aimItem.getVolume() - item.getVolume());
            }

        }
    }

    /**
     * в полях bid, ask class Dom, в итоге использован Collections.reverseOrder();
     *
     * @param map
     * @return
     */
    public TreeMap<Integer, Item> sortItems(TreeMap<Integer, Item> map) {
        ItemComparator comparator = new ItemComparator(map);
        TreeMap<Integer, Item> tree = new TreeMap<Integer, Item>(comparator);
        tree.putAll(map);
        return tree;
    }
}
