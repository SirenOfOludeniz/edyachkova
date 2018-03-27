package ru.job4j.service;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractSimple<E> implements Iterable<E>{
    Object[] objects;
    int index = 0;
    public void add(E value) {
        objects[index++] = value;
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
    }

