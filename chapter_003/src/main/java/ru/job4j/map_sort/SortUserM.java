package ru.job4j.map_sort;
import java.util.*;

public class SortUserM {
    public Set<UserM> sortByage (List<UserM> list) {
        Set<UserM> treeset = new TreeSet<>();
        for (UserM userM : list) {
            treeset.add(list.get(list.indexOf(userM)));
        }

        for (UserM userM : treeset) {
           System.out.println("age " + userM.getAge());
        }
        return treeset;
    }

    public List<UserM> sortNameLength (List<UserM> list) {
        ArrayList<UserM> list1 = new ArrayList<UserM>(list);
        list1.sort(new Comparator<UserM>() {
            @Override
            public int compare(UserM o1, UserM o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        for (UserM userM : list1) {
            System.out.println("Name lenght " + list1.get(list1.indexOf(userM)).getName());
        }
        return list1;
    }
    public List<UserM> sortByAllFields (List<UserM> list) {

        list.sort(new Comparator<UserM>() {
            @Override
            public int compare(UserM o1, UserM o2) {
                int ageDifference = o1.getAge() - o2.getAge();
                int nameCompare = o1.getName().compareTo(o2.getName());
                int result = nameCompare != 0 ? nameCompare : ageDifference;
                return result;
            }
        });
        for (UserM userM : list) {
            System.out.println("sort by name and age " + list.get(list.indexOf(userM)).getName() +
                    list.get(list.indexOf(userM)).getAge());
        }

        return list;
    }

}
