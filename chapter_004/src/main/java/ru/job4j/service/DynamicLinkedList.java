package ru.job4j.service;

import java.util.ConcurrentModificationException;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicLinkedList<E> implements SimpleContainer<E> {

    public Node<E> first;
    public Node<E> last;
    int modCount = 0;

    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return last.index;
    }



    @Override
    public void add(E e) {
        //вставка в конец
        Node<E> node = new Node<>(last, e, null);
        if (isEmpty()) {
            first = node;
        }
        else {
            last.next = node;
            node.prev = last;
        }
        last = node;
        modCount++;
    }
    public Node<E> findNode(int position) {
        Node<E> current = first;
        while (current.index != position) {
            current = current.next;
        }
        return current;
    }
    public void delete(int position) {
        Node<E> current = findNode(position);
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    @Override
    public E get(int position) {
        Node<E> current = first;
        while (current.index != position) {
            current = current.next;
        }
        return current.item;
    }

    @Override
    public Iterator<E> iterator() {
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

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
        int index = 0;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
            index++;
        }
    }
}
