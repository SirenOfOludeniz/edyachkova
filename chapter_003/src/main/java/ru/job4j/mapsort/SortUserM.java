package ru.job4j.mapsort;
import java.util.*;

public class SortUserM {
    /**
     *
     * @param list
     * @return
     * //        for (UserM userM : list) {
    //            treeset.add(list.get(list.indexOf(userM)));
    //        }
     */
    public Set<UserM> sortByage(List<UserM> list) {
        Set<UserM> userMS = new TreeSet<>();
        userMS.addAll(list);
        for (UserM userM : userMS) {
           System.out.println("age " + userM.getAge());
        }
        return userMS;
    }
    public List<UserM> sortNameLength(List<UserM> list) {
        ArrayList<UserM> users = new ArrayList<UserM>(list);
        users.sort(new Comparator<UserM>() {
            @Override
            public int compare(UserM o1, UserM o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        for (UserM userM : users) {
            System.out.println("Name lenght " + users.get(users.indexOf(userM)).getName());
        }
        return users;
    }
    public List<UserM> sortByAllFields(List<UserM> list) {
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
            System.out.println("sort by name and age "
                    + list.get(list.indexOf(userM)).getName()
                    + list.get(list.indexOf(userM)).getAge());
        }
        return list;
    }
}
