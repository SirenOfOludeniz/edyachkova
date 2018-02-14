package ru.job4j.prevs_tracker_menutr;

import java.util.ArrayList;

public class ArrayListTestMethods {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<>();
       Dog rex = new Dog();
       Dog chij = new Dog();
       Dog bobik = new Dog();

       dogs.add(rex);
       dogs.add(chij);
       dogs.add(bobik);


       dogs.remove(rex);
    }
}
