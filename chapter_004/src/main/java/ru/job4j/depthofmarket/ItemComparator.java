package ru.job4j.depthofmarket;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ItemComparator implements Comparator<Integer>{

    TreeMap<Integer, Item> map;

    public ItemComparator(TreeMap<Integer, Item> map) {
        this.map = map;
    }

    /**
     * метод compare реализован наоборот.
     * если 1й объект больше 2го, то -1
     * если 2й объект больше 1го, то 1
     * потому что заявки должны идти по убыванию
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Integer o1, Integer o2) {
       //return o1.getPrice() == o2.getPrice() ? 0 : (o1.getPrice() > o2.getPrice() ? -1 : 1);
        //return map.get(o1).getPrice() == map.get(o2).getPrice() ? 0 : (map.get(o1).getPrice() > map.get(o2).getPrice() ? -1 : 1);
        return Integer.compare(map.get(o2).getPrice(), map.get(o1).getPrice());
    }
    /**
     * идея предложила заменить вот это:
     *  return o1.getPrice() == o2.getPrice() ? 0 : (o1.getPrice() > o2.getPrice() ? -1 : 1);
     *  на вот это:
     *   return Integer.compare(o2.getPrice(), o1.getPrice());
     *
     *   это вообще можно? так нормально?
     */
}
