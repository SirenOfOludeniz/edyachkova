package ru.job4j.collesctionsexamplefrompetr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListExample {
    static class User {
        private final String name;

        User(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            User user = (User) o;

            return name != null ? name.equals(user.name) : user.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User("petr"));
        boolean result = users.contains(new User("petr"));
        System.out.println("new User " + result); // false

        User user = new User("brbr");
        users.add(user);
        boolean result2 = users.contains(user);
        System.out.println("result2 " + result2);
        users.addAll(Arrays.asList(new User("p"), new User("k")));

        Integer[] nums = {3, 4, 5};
        ArrayList<Integer> ff = new ArrayList<>();
        ff.addAll(Arrays.asList(nums));

        Iterator<User> it = users.iterator();
        while (it.hasNext()) { //проверка на наличее следующего значения
            System.out.println(it.next()); //получение значения, сдвиг на следующий
        }

        users.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println("user из forEach " + user);
            }
        });

        users.forEach(user1 -> System.out.println("user form lambda" + user));


    }
}
