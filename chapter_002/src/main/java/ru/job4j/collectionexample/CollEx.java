package ru.job4j.collectionexample;

import java.util.ArrayList;
import java.util.List;

public class CollEx {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(425);
        Integer value = list.get(0);
        //System.out.println(value);
        list.add(1, 32);
        //list.add(23, 177);
       // Integer value2 = list.get(23);
        //System.out.println(value2);
        System.out.println(list.get(0));
        System.out.println(list.get(1));

        List<Integer> flats = new ArrayList<>();
        flats.add(4);
        flats.add(3);
        list.addAll(flats);
       // System.out.println("indexOf :" + list.indexOf(4));
        System.out.println(String.format("indexOf :%s", list.indexOf(4)));


    }
}
