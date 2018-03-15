package ru.job4j.service;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
       // System.out.println("first output : " + linkedList);
        linkedList.add(7);
       // System.out.println("2nd output " + linkedList);
        //System.out.println(linkedList.get(2));
        linkedList.remove(1);
        System.out.println(linkedList);
       /* int[] array = {1,2,4,6};
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        for (int i = 0; i < copy.length; i++) {
            System.out.println(copy[i]);
        }*/

    }
}
