package ru.job4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class CheckLinkedList {
    public static void main(String[] args) {
        ArrayList<String> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add("a");
        }


        for (int i = 0; i < 5; i++) {

            //nums.remove(4);
            //nums.remove(i); //by index

        }
        // nums.removeIf(x -> x > 5);
        //nums.removeIf(x -> x.length() > 2);
//        for (int i = 0; i < 5; i++) {
//            nums.remove(0);
//        }
        // nums.remove()
        System.out.println(nums);

        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < 10 ; i++) {
            list.add("Masha" + i);
        }
//        for (int i = 0; i < 5 ; i++) {
//            list.remove(0);
//        }
        System.out.println(list);

        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            treeSet.add("Ananas" + i);
        }

        for (int i = 0; i < 5 ; i++) {
            treeSet.remove(treeSet.first());

        }
        System.out.println(treeSet);


































    }
}
