package ru.job4j.map_sort;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class SortUserMTest {
    @Test
    public void sortUserMTest() {
        SortUserM sortUserM = new SortUserM();
        ArrayList<UserM> list = new ArrayList<>();

        for (int i = 33; i <35 ; i++) {
            list.add(new UserM(i));
        }
        for (int i = 5; i < 9 ; i++) {
            list.add(new UserM(i));
        }
        for (int i = 23; i < 25; i++) {
            list.add(new UserM(i));
        }
        sortUserM.sort(list);

       // System.out.println(sortUserM.sort(list));

    }

}
