package ru.job4j.service;

import java.util.*;
import java.util.function.Consumer;

public class SimpleList<E> implements Iterable<E> {
    Object[] objects;
    int index = 0;

    public SimpleList(int size) {
        this.objects = new Object[size];
    }

    public <K> K print(K value) {
        System.out.println(value);
        return value;
    }

    public void add(E value) { //lowCasting понижаем тип до типа Object
        this.objects[index++] = value;
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

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return index < objects.length;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) objects[index++];
            }
        };
    }
    //как использовать ArrayList
    public void showList() {
        List<String> list = new ArrayList<>(100);
    List<Integer> numbers = new LinkedList<>();
    numbers.add(1);

    }
}
