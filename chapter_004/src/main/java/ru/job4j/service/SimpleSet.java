package ru.job4j.service;

public class SimpleSet<E> extends AbstractSimple<E> {

    public void add(E value) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].equals(value)) {
                return;
            }
           super.add(value);
        }
    }

    }

