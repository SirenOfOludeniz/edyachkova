package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E>{

    Node<E> root;

    public Tree(E index) {
        this.root = new Node<>(index);
    }

    /**
     * false - если дуликатов не найдено
     * true, если нашелся дубликат
     * @param value
     * @return
     */
    public boolean contain(E value) {
        boolean result = false;
        try {
            if (findBy(value).get().eqValues(value)) {
                result = true;
            }
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
        }
        return result;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (!contain(child)) {
            Node<E> childNode = new Node<>(child);
            findBy(parent).get().add(childNode);
            result = true;
        }

        return result;
    }


    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root); //добавили в конец элемент
        while (!data.isEmpty()) {
            Node<E> el = data.poll(); //удалили из начала списка с сохранением элемента в el
            if (el.eqValues(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            Node<E> current = root;
            Node<E> next = null;
            Queue<Node<E>> data = new LinkedList<>();

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (next() != null) {
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
                for (Node<E> child : next.leaves()) {
                    data.offer(child);
                }
                current = data.poll();
                return next.value;
            }
        };
    }

    static class Node<E extends Comparable<E>> {

        private final List<Node<E>> children = new ArrayList<>();
        private final E value;

        public Node(final E value) {
            this.value = value;
        }
        public void add(Node<E> child) {
            this.children.add(child);
        }
        public List<Node<E>> leaves() {
            return this.children;
        }
        public boolean eqValues(E that) {
            return this.value.compareTo(that) == 0;
        }
    }
}
