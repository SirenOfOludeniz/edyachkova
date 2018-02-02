package ru.job4j.peerreview;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.*;
public class SorterTest {
    @Test
    public void sortListReturnTreeSet() {
        Sorter sorter = new Sorter();
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("Vasya", 31));
        list.add(new User("Anton", 34));
        list.add(new User("Ivan", 23));
        //System.out.println(sorter.sort(list));
        sorter.sort(list);
//        for (User user : list) {
//            System.out.println(user.getName());
//        }
        System.out.println(list);
    }
}
