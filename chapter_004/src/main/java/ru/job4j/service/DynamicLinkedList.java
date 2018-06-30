package ru.job4j.service;

import java.util.ConcurrentModificationException;

import java.util.Iterator;
import java.util.NoSuchElementException;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
@ThreadSafe
public class DynamicLinkedList<E> implements SimpleContainer<E> {
    @GuardedBy("this")
    public Node<E> first;
    public Node<E> last;
    int modCount = 0;
    int indexElement = 0;

    public boolean isEmpty() {
        synchronized (this) {
            return first == null;
        }
    }
    public int size() {
        synchronized (this) {
            if (isEmpty()) {
                return 0;
            }
        }
        return this.indexElement;
    }



    @Override
    public synchronized void add(E e) {
        //вставка в конец
        Node<E> node = new Node<>(last, e, null, this.indexElement);
        if (isEmpty()) {
            first = node;
        }
        else {
            last.next = node;
            node.prev = last;
        }
        last = node;
        modCount++;
        this.indexElement++;
    }
    public synchronized Node<E> findNode(int position) {
        Node<E> current = this.first;
        while ( current.index != position) {
            System.out.println("current.index " + current.index);
            current = current.next;
        }
        return current;
    }
    public synchronized void delete(int position) {
        Node<E> current = findNode(position);
        System.out.println("current from delete " + current.getItem());
        System.out.println("current.next from delete " + current.next.getItem());
        System.out.println("current.prev from delete " + current.prev.getItem());
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    @Override
    public synchronized E get(int position) {
        Node<E> current = this.first;
        while (current == null && current.index != position) {
            current = current.next;
        }
        return current.item;
    }

    @Override
    public synchronized Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> current;
            Node<E> next = first;
            int indexIter = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                boolean result = false;

                current = next;

                if (isEmpty()) {
                    result = false;
                }
                else {
                    if (current != null) {
                        result = true;
                    }
                    else result = false;
                }

                return result;
            }
            @Override
            public E next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
               // return get(indexIter++);
                current = next;
                next = current.next;
                return current.item;
            }
        };
    }

    public static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
        int index = 0;

        Node(Node<E> prev, E element, Node<E> next, int index) {
            this.item = element;
            this.next = next;
            this.prev = prev;
            this.index = index;
        }

        public E getItem() {
            return item;
        }
    }
}
