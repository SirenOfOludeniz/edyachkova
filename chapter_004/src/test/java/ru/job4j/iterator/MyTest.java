package ru.job4j.iterator;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class MyTest {
    public static void main(String[] args) {
        int two = 2;
       /* System.out.println(1%two);
        System.out.println(2%two);
        System.out.println(3%two);
        System.out.println(4%two);
        System.out.println(5%two);
        System.out.println(6%two);
        System.out.println(7%two);*/

        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (i % 2 == 0) {
                ++count;
                System.out.println(count);
            }
        }
    }
}
