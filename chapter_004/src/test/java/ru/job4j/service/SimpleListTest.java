package ru.job4j.service;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class SimpleListTest {
    public class A {}
    public class B extends A {}
    public class C extends B {}


    @Test
    public void getGeneric() {
        Stack simple = new Stack(4);
        simple.add("test");
        String result = simple.get(0);

        assertThat(result, is("test"));
    }
    @Test
    public void whenCreateContainerShouldReturnTheSameType() {
        SimpleList<String> simple = new SimpleList<>(4);
        simple.add("test");
        String result = simple.get(0);

        assertThat(result, is("test"));
    }

    @Test
    public void whenTypeIntShouldReturnTheInteger() {
        SimpleList<Integer> simple = new SimpleList<>(4);
        simple.add(2);
        int result = simple.get(0);

        assertThat(result, is(2));
    }

    public void wildTest() {
        //demo work code
        SimpleList<B> list = new SimpleList<>(10);
        //можем вставить любые значения, которые расширяют класс Ф
        //list.add(new A());
        list.add(new B());
        list.add(new C());
        print(list);

        printUpper(list); //здесь ругается, потому что
        //используем тип А в list

        printLow(list);
    }
    public void print(SimpleList<?> list) {
        //todo print
    }

    public void printUpper(SimpleList<? extends B> list) {
        //повышающий
        //тип А в качестве параметра не примет этот метод
    }
    public void printLow(SimpleList<? super B> list) {
        //понижающие ограничения
        //можем использовать либо класс B, либо
        //классы, которые являются родителем классу В
    }


}