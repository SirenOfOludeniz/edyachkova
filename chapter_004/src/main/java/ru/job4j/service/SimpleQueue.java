package ru.job4j.service;

public class SimpleQueue<E> {
    DynamicLinkedList<E> linkedList;
    private int front;

    public SimpleQueue() {
        linkedList = new DynamicLinkedList<>();
        front = 0;
    }
    public void push(E value) {
        linkedList.add(value);
    }
    public E poll() {
        return linkedList.get(front--);
    }
}
