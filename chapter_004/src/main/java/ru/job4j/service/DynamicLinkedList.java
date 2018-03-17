package ru.job4j.service;

import java.util.Iterator;

public class DynamicLinkedList<E> implements SimpleContainer<E> {

    public Node<E> first;
    public Node<E> last;
    public int size = last.index + 1;

    /**А мне нужен метод isEmpty?
     * если да, то что проверять? first ? last?
     * или и то и то?
     * @param e
     */

    @Override
    public void add(E e) {
        //вставка в конец
        Node<E> node = new Node<>(first, e, last);
        last.next = node;
        node.prev = last;
        last = node;
    }

    @Override
    public E get(int position) {
        Node<E> current = last;
        while (current.index != position) {
            current = current.next;
        }

        return current.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
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
