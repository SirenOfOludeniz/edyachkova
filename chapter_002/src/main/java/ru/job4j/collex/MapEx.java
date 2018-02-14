package ru.job4j.collex;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MapEx {
    public static void main(String[] args) {
        /*Map<String, Integer> students = new HashMap<>();
        students.put("Katya", 3);
        students.put("Ivan", 5);
        System.out.println(students.get("Katya"));
        for (String student : students.keySet()) {
            System.out.println(String.format("%s : %s", student, students.get(student)));
        }
        for (Integer scope : students.values()) {
            System.out.println(String.format("%s", scope));
        }*/

        LinkedList<String> states = new LinkedList<>();
        states.add     ("Германия"      );
        states.add     ("Франция"       );
        states.addLast ("Великобритания"); // добавляем элемент в конец
        states.addFirst("Испания"       ); // добавляем элемент в первую позицию
        System.out.println(states);
        states.add     (1, "Италия"     ); // добавляем элемент с индексом 1
        System.out.println(states);
        states.set(1, "brbr");
        System.out.println(states);
        System.out.println(states.get(3));

    }
}
