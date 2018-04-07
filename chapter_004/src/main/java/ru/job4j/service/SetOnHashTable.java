package ru.job4j.service;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SetOnHashTable<E> implements Iterable<E> {
    Object[] objects;
    int index = 0;
    int sizeArray;

    public SetOnHashTable(int size) {
        this.sizeArray = size;
        this.objects = new Object[size];
    }

    public void overSize() {
        int size;
        Object[] copy;
        if (this.index == this.objects.length) {
            copy = this.objects;
            size = this.objects.length * 2;
            this.sizeArray = size;
            this.objects = new Object[size];
            System.arraycopy(copy, 0, this.objects, 0, copy.length);
        }
    }

    public int hashFunction(int key) {
        return key % this.objects.length;
    }

    public boolean add(E e) {
        overSize();
        boolean result = true;
        if (contains(e)) {
            this.objects[hashFunction(e.hashCode())] = e;
            index++;
        } else {
            result = false;
        }
        return result;
    }


    public boolean contains(E e) {
        boolean result = true;
       if (this.objects[hashFunction(e.hashCode())] != null && this.objects[hashFunction(e.hashCode())].equals(e)) {
           result = false;
       }
        return result;
    }

    public boolean remove(E e) {
        boolean result = false;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].equals(e)) {
                objects[i] = null;
                result = true;
            }

        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
         int indexEl = 0;
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return next() != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    return (E) objects[index++];
                }

            }
        };
    }
}
