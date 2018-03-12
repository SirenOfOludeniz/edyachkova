package ru.job4j.service;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<E> implements SimpleContainer<E> {
    Object[] container = new Object[10];
    int index = 0;
    int modCount = 0;

    public DynamicArray() {
        arraycopy();
    }

    public void arraycopy() {
        int size = 0;
        Object[] copy = new Object[container.length];
        if (index == container.length) {
            copy = this.container;
            size = ((this.container.length * 3)/2 + 1);
            this.container = new Object[size];
            System.arraycopy(copy, 0, this.container, 0, copy.length);
        }
    }


    @Override
    public void add(E o) {
        this.container[index++] = o;
        this.modCount++;
    }

    @Override
    public E get(int position) {
        return (E) this.container[position];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                return index < container.length;
            }

            /**
             *  Object[] container = DynamicArray.this.container;
             *  скопировано из метода next в ArrayList
             *  там нечно похожее
             *
             */

            @Override
            public E next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object[] container = DynamicArray.this.container;
                if (index >= container.length) {
                    throw new ConcurrentModificationException();
                }
                System.out.println("modCount = " + modCount);
                System.out.println("expectedModCount = " + expectedModCount);
                return (E) container[index++];
            }
        };
    }
}
