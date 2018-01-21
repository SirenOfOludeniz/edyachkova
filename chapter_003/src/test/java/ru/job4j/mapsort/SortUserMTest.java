package ru.job4j.mapsort;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class SortUserMTest {
    @Test
    public void sortUserMTest() {
        SortUserM sortUserM = new SortUserM();
        ArrayList<UserM> list = new ArrayList<>();

        for (int i = 33; i < 35; i++) {
            list.add(new UserM(i));
        }
        for (int i = 5; i < 9; i++) {
            list.add(new UserM(i));
        }
        for (int i = 23; i < 25; i++) {
            list.add(new UserM(i));
        }
        sortUserM.sortByage(list);

       // System.out.println(sortUserM.sort(list));

    }
    @Test
    public void sortNameLenghtTest() {

        SortUserM sortUserM = new SortUserM();
        ArrayList<UserM> list = new ArrayList<>();
        list.add(new UserM("Ivan", 12));
        list.add(new UserM("Vasya", 35));
        list.add(new UserM("Sasha", 17));
        list.add(new UserM("Abraham", 5));
        list.add(new UserM("Abragam", 10));
        list.add(new UserM("Moisha", 38));

        sortUserM.sortNameLength(list);
    }
    @Test
    public void sortByNameAndAgeTest() {
        SortUserM sortUserM = new SortUserM();
        ArrayList<UserM> list = new ArrayList<>();
        list.add(new UserM("Ivan", 12));
        list.add(new UserM("Vasya", 35));
        list.add(new UserM("Sasha", 17));
        list.add(new UserM("Abraham", 5));
        list.add(new UserM("Abragam", 10));
        list.add(new UserM("Moisha", 38));

        sortUserM.sortByAllFields(list);
    }

}
