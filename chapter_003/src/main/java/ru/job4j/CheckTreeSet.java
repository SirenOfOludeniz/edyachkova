package ru.job4j;

import java.util.TreeSet;

public class CheckTreeSet {
    public static void main(String[] args) {

        TreeSet<String> states = new TreeSet<String>();

        // добавим в список ряд элементов
        states.add("Германия");
        states.add("Франция");
        states.add("Италия");
        states.add("Великобритания");

        System.out.printf("В списке %d элементов \n", states.size());

       // states.remove("Германия");
        for (String state : states) {

            System.out.println(state);
        }

        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(9);
        numbers.add(3);
        numbers.add(6);
        System.out.println("numbers :" + numbers);
    }
}
