package ru.job4j.iterator;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class MyTest {
    public static void main(String[] args) {
        System.out.println(2 % 2);

        for (int i = 1; i <= 2 ; i++) {
            System.out.println("f");
        }
        System.out.println(6 % 3);
    }
}
