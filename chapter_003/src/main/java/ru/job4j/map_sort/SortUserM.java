package ru.job4j.map_sort;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUserM {
    public Set<UserM> sort (List<UserM> list) {
        Set<UserM> treeset = new TreeSet<>();

        for (int i = 0; i < list.size() ; i++) {
            treeset.add(list.get(i));
        }
        //System.out.println(treeset);
        for (UserM userM : treeset) {
           System.out.println("age " + userM.getAge());
        }
        return treeset;
    }

    /*public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(9);
        set.add(1);
        set.add(2);
        set.add(33);
        System.out.println(set);
    }*/
}
