package ru.job4j.lafore;

public class DoublyLinkedList {
    Link first = null;
    Link last = null;
    public boolean isEmpty() {
        return first == null;
    }


    public void insertFirst(int dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }
            newLink.next = first;
            first = newLink;

        //получается, если first изначально = null,
        // то мы вставим 2 одинаковых newLink
        // в last и в first?
    }


    public void insertLast(int dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            first = newLink; // почему не в last?
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
            last = newLink;

    }

    public Link deleteFirst() {
        Link temp = first;
        if (first.next == null) {
            last = null; // почему last, а не first?
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    public Link deleteLast() {
        Link temp = last;
        if (first.next == null) {
            first = null; // почему first, а не last?
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }

    public boolean insertAfter(Link newLink, int key) {
        //вставляет новый элемент после элемента с заданным ключом
        Link current = first;
        while (current.dData != key) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        if (current == last) { // почему здесь == , а не equal?
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }
    public void displayForward() {
        System.out.println("List (first --> last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
    public void displayBackward() {
        System.out.println("List (last --> first");
        Link current = last;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
