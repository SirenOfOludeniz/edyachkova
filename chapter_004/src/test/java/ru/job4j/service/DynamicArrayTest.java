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
        dynamicArray.add("B");
        dynamicArray.add("V");
        dynamicArray.add("C");
        dynamicArray.add("D");
        //System.out.println(dynamicArray);
        /**
         * почему не выводит первый элемент "А"?
         */
        for (String a : dynamicArray) {
            System.out.println("вывод в цикле for-each " + a);
        }

        Iterator<String> iterator = dynamicArray.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("вывод по итератору : " + element);
        }


        System.out.println("Вывод вне цикла, по методу get : " + dynamicArray.get(0));

        for (int i = 0; i < 30; i++) {
            dynamicArray.add("bb");
        }

        System.out.println("method get() : " + dynamicArray.get(0));

        for (String b : dynamicArray) {
            System.out.println("for-each after 30 times add bb : " + b);
        }



        /**
         * здесь кидает ConcurrentModificationException
         * так и должно быть

        for (String d : dynamicArray) {
            dynamicArray.add("jj");
            System.out.println(d);
        }*/
    }

}
