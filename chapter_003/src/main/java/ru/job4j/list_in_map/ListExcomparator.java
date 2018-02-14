package ru.job4j.list_in_map;

import ru.job4j.listinmap.User;

import java.util.*;

public class ListExcomparator {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.addAll(
                Arrays.asList(
                        new User("pert"),
                        new User("ivan"),
                        new User("zuma")
                )
        );
        System.out.println("not sorted " + users);
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
                // будет отсортирован по возрастанию
            }
        });
        System.out.println("sorted " + users);

        Set<User> userSet = new TreeSet<>(); // можно передать компаратор в круглые скобки
        //или применить интерфейс Comparable
        userSet.addAll(
                Arrays.asList(
                        new User("katya"),
                        new User("ana"),
                        new User("mona")
                )
        );
        System.out.println(userSet);

    }
}
