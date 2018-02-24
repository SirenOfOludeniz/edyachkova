package ru.job4j.collectionexample;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(1);
        set.add(4);

        for (Integer value : set) {
            System.out.println(value);
        }
    }
}
