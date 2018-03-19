package ru.job4j.service;

public class SimpleStack<E> {
    DynamicLinkedList<E> linkedList;
    int top;

    public SimpleStack() {
        linkedList = new DynamicLinkedList<>();
        top = -1;
    }

    public void push(E value) {
        ++top;
        linkedList.add(value);
    }
    public E poll() {
        return linkedList.get(top--);
    }

}
