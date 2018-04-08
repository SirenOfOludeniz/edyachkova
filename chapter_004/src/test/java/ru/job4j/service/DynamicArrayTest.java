package ru.job4j.service;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class DynamicArrayTest {

    @Test
    public void dynamicArrayTest() {
        DynamicArray<String> dynamicArray = new DynamicArray();
        String name = "A";
        dynamicArray.add(name);
        //System.out.println(dynamicArray);
        /**
         * почему не выводит первый элемент "А"?
         */
        for (String a : dynamicArray) {
            System.out.println(a);
        }
        System.out.println("Вывод вне цикла, по методу get : " + dynamicArray.get(0));

        for (int i = 0; i < 100500; i++) {
            dynamicArray.add("bb");
        }
    }

    /**
     * здесь кидает ConcurrentModificationException
     * так и должно быть
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenExpectException() {
        DynamicArray<String> dynamicArray = new DynamicArray();
        dynamicArray.add("A");
        for (String d : dynamicArray) {
        dynamicArray.add("jj");
        System.out.println(d);
    }
}






}
