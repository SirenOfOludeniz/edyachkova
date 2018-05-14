package ru.job4j.depthofmarket;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ActionSystemTest {
    /**
     * type: add/delete
     * action: bid/ask
     */
    @Test
    public void addItemTest() {
        ActionSystem action = new ActionSystem();
        Dom dom = new Dom("Gas");

        action.addItem(new Item(1, "Gas", true, false, 20, 10), dom.ask, dom);
        action.addItem(new Item(2, "Gas", true, false, 20, 10), dom.ask, dom);
        action.addItem(new Item(3, "Gas", true, false, 15, 10),dom.ask, dom);
        action.addItem(new Item(4, "Gas", true, false, 15, 10), dom.ask, dom);
        action.addItem(new Item(5, "Gas", true, false, 15, 10),dom.ask, dom);
        action.addItem(new Item(6, "Gas", true, false, 10, 10), dom.ask, dom);

        action.addItem(new Item(7, "Gas", true, true, 20, 10), dom.bid, dom);
        action.addItem(new Item(8, "Gas", true, true, 20, 10), dom.bid, dom);
        action.addItem(new Item(9, "Gas", true, true, 15, 10), dom.bid, dom);
        action.addItem(new Item(10, "Gas", true, true, 15, 10), dom.bid, dom);
        action.addItem(new Item(11, "Gas", true, true, 15, 10), dom.bid, dom);
        action.addItem(new Item(12, "Gas", true, true, 10, 10), dom.bid, dom);
    }
    @Test
    public void visualTest() {
        ActionSystem action = new ActionSystem();
        Dom dom = new Dom("Gas");
        Menu menu = new Menu();

        action.inputItem(new Item(1, "Gas", true, false, 20, 10), dom);
        action.inputItem(new Item(2, "Gas", true, false, 20, 10), dom);
        action.inputItem(new Item(3, "Gas", true, false, 15, 10), dom);
        action.inputItem(new Item(4, "Gas", true, false, 15, 10), dom);
        action.inputItem(new Item(5, "Gas", true, false, 15, 10), dom);
        action.inputItem(new Item(6, "Gas", true, false, 10, 10), dom);

        action.inputItem(new Item(7, "Gas", true, true, 9, 10), dom);
        action.inputItem(new Item(8, "Gas", true, true, 7, 10),  dom);
        action.inputItem(new Item(9, "Gas", true, true, 7, 10),  dom);
        action.inputItem(new Item(10, "Gas", true, true, 5, 10), dom);
        action.inputItem(new Item(11, "Gas", true, true, 5, 10), dom);
        action.inputItem(new Item(12, "Gas", true, true, 4, 10), dom);


        menu.visual("Gas");
    }
    @Test
    public void visualTest2() {
        ActionSystem action = new ActionSystem();
        Dom dom = new Dom("Gas");
        Menu menu = new Menu();

        action.addItem(new Item(1, "Gas", true, false, 20, 10), dom.ask, dom);
        action.addItem(new Item(2, "Gas", true, false, 20, 10), dom.ask, dom);
        action.addItem(new Item(3, "Gas", true, false, 15, 10),dom.ask, dom);
        action.addItem(new Item(4, "Gas", true, false, 15, 10), dom.ask, dom);
        action.addItem(new Item(5, "Gas", true, false, 15, 10),dom.ask, dom);
        action.addItem(new Item(6, "Gas", true, false, 10, 10), dom.ask, dom);

        action.addItem(new Item(7, "Gas", true, true, 20, 10), dom.bid, dom);
        action.addItem(new Item(8, "Gas", true, true, 20, 10), dom.bid, dom);
        action.addItem(new Item(9, "Gas", true, true, 15, 10), dom.bid, dom);
        action.addItem(new Item(10, "Gas", true, true, 15, 10), dom.bid, dom);
        action.addItem(new Item(11, "Gas", true, true, 15, 10), dom.bid, dom);
        action.addItem(new Item(12, "Gas", true, true, 10, 10), dom.bid, dom);

        menu.visual("Gas");
    }
    @Test
    public void createMergeItemAlgorithm() {

        ActionSystem actionSystem = new ActionSystem();
        Menu menu = new Menu();

        TreeMap<Integer, Item> ask = new TreeMap<>();
        ask.put(0, new Item(0, "Gas", true, false, 20, 10));
        ask.put(1, new Item(1, "Gas", true, false, 20, 10));
        ask.put(2, new Item(2, "Gas", true, false, 20, 10));
        ask.put(3, new Item(3, "Gas", true, false, 15, 10));
        ask.put(4, new Item(4, "Gas", true, false, 15, 10));
        ask.put(5, new Item(5, "Gas", true, false, 15, 10));
        ask.put(6, new Item(6, "Gas", true, false, 10, 10));

        TreeMap<Integer, Item> bid = new TreeMap<>();
        bid.put(7, new Item(7, "Gas", true, true, 20, 10));
        bid.put(8, new Item(8, "Gas", true, true, 20, 10));
        bid.put(9, new Item(9, "Gas", true, true, 15, 10));
        bid.put(10, new Item(10, "Gas", true, true, 15, 10));
        bid.put(11, new Item(11, "Gas", true, true, 15, 10));
        bid.put(12, new Item(12, "Gas", true, true, 10, 10));

        menu.visual("Gas", bid, ask);

    }
    @Test
    public void createMerge() {
        ActionSystem actionSystem = new ActionSystem();
        Menu menu = new Menu();

        TreeMap<Integer, Item> ask = new TreeMap<>();
        ask.put(0, new Item(0, "Gas", true, false, 20, 10));
        ask.put(3, new Item(3, "Gas", true, false, 15, 10));
        ask.put(1, new Item(1, "Gas", true, false, 20, 10));
        ask.put(4, new Item(4, "Gas", true, false, 15, 10));
        ask.put(2, new Item(2, "Gas", true, false, 20, 10));
        ask.put(5, new Item(5, "Gas", true, false, 15, 10));
        ask.put(6, new Item(6, "Gas", true, false, 10, 10));

        TreeMap<Integer, Item> bid = new TreeMap<>();
        bid.put(7, new Item(7, "Gas", true, true, 20, 10));
        bid.put(8, new Item(8, "Gas", true, true, 20, 10));
        bid.put(9, new Item(9, "Gas", true, true, 15, 10));
        bid.put(10, new Item(10, "Gas", true, true, 15, 10));
        bid.put(11, new Item(11, "Gas", true, true, 15, 10));
        bid.put(12, new Item(12, "Gas", true, true, 10, 10));

        menu.visual("Gas", bid, ask);
    }

}