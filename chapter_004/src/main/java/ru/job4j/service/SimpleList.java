package ru.job4j.service;

import java.util.*;
import java.util.function.Consumer;

public class SimpleList<E> extends AbstractSimple<E> {

    public SimpleList(int size) {
        this.objects = new Object[size];
    }

    public <K> K print(K value) {
        System.out.println(value);
        return value;
    }

    public E get(int position) {
        //делаем приведение типов
        return (E) this.objects[position];

    }

    public E set(int position, E element) {
        this.objects[position] = element;
        return element;
    }
    public E delete(int position) {
        E element =(E) this.objects[position];
        this.objects[position] = null;
        return element;
    }


    //как использовать ArrayList
    public void showList() {
        List<String> list = new ArrayList<>(100);
    List<Integer> numbers = new LinkedList<>();
    numbers.add(1);

    }
}
