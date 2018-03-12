package ru.job4j.service;
import org.junit.Test;

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
//        for (String a : dynamicArray) {
//            System.out.println(a);
//        }
        System.out.println("Вывод вне цикла, по методу get : " + dynamicArray.get(0));


        /**
         * здесь должен кинуть ConcurrentModificationException
         * но не кидает, если раскомментить первый цикл for-each. почему?
         */
        for (String d : dynamicArray) {
            dynamicArray.add("jj");
            System.out.println(d);
        }
    }

}
