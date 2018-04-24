package ru.job4j.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BinarySearchTree<E extends Comparable<E>> implements Iterable<E> {

    Node<E> root;

    public BinarySearchTree(E e) {
        root = new Node<>(e);
    }

    public void add(E child) {
        Node<E> root = this.root;
        while (true) {
            if (child.compareTo(root.value) == 1) {
                if (root.right == null) {
                    root.right = new Node<>(child);
                    break;
                }
                else root = root.right;
            }
            else {
                if (root.left == null) {
                    root.left = new Node<>(child);
                    break;
                }
                else root = root.left;
            }
        }
    }
    public E find(E e, E a) {
        Node<E> result = new Node<>(a);
        LinkedList<Node<E>> list = new LinkedList<>();
        list.offer(this.root);
        while (!list.isEmpty()) {
            Node<E> current = list.poll();
            if (current.value != null && current.value.equals(e)) {
                result = current;
                break;
            }
            if (current.right != null) {
                list.offer(current.right);
            }
            if (current.left != null) {
                list.offer(current.left);
            }
        }
        return result.value;
    }



    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> current = root;
            Node<E> next = null;
            LinkedList<Node<E>> list = new LinkedList<>();
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (current != null) {
                    result = true;
                }
                return result;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                next = current;
                if (current.left != null) {
                    list.offer(current.left);
                }
                if (current.right != null) {
                    list.offer(current.right);
                }
                current = list.poll();
                return next.value;
            }
        };
    }
}
class Node<E extends Comparable<E>> {
    E value;
    Node<E> right;
    Node<E> left;

    public Node(E e) {
        this.value = e;
    }
}
