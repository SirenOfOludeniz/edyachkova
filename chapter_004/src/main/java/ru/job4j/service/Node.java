package ru.job4j.service;

public class Node<T> {
    T value;
    Node<T> next;
    public Node(T value) {
        this.value = value;
    }
}
