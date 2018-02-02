package ru.job4j.peerreview;
import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class SorterTest {
    @Test
    public void sortTest() {
        Sorter sorter = new Sorter();
        User user = new User("Ivan");
        User user1 = new User("Vasya");
        User user2 = new User("Borya");
        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        System.out.println(sorter.sort(list));
    }
    @Test
    public void sortByNameLenght() {
        Sorter sorter = new Sorter();
        User user = new User("Ivan");
        User user1 = new User("Vasya");
        User user2 = new User("Borya");
        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        System.out.println(sorter.sortnamelength(list));
    }
    @Test
    public void sortBothTest() {
        Sorter sorter = new Sorter();
        User user = new User("Ivanus");
        User user1 = new User("Vasyan");
        User user2 = new User("BoryaVadim");
        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        System.out.println(sorter.sortboth(list));
    }
}
