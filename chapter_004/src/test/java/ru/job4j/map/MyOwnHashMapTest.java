package ru.job4j.map;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyOwnHashMapTest {
    @Test
    public void hashMapTest() {
        MyOwnHashMap<Integer, String > map = new MyOwnHashMap<>(100);
        map.insert(1, "Vasya");
        map.insert(2, "Lilya");
        map.insert(3, "Olga");

        map.display();

        System.out.println("get 2 " + map.get(2));

        System.out.println("delete 3 " + map.delete(3));
    }
}