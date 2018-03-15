package ru.job4j.service;

import java.util.Iterator;

public class DynamicLinkedList<E> implements SimpleContainer<E> {

    public Node<E> first;
    public Node<E> last;
    public int size;



    @Override
    public void add(E e) {
        Node<E> node = new Node<>(first, e, last);
        node.prev = last;


    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
