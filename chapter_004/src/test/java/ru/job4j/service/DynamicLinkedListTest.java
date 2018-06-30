package ru.job4j.service;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

public class DynamicLinkedListTest {

    @Test
    public void test(){
        DynamicLinkedList<String> list = new DynamicLinkedList<>();
        list.add("V");
        list.add("D");
        list.add("N");
        list.add("E");

        list.delete(2);

        System.out.println(list.size());

        for (String a : list) {
            System.out.println(a);
        }

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("elem : " + element);
        }





        System.out.println(list.get(0));

      assertThat(list.get(0), is("V"));

    }



}