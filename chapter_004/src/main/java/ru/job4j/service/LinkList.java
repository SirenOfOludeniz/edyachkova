package ru.job4j.service;

public class LinkList {

    private Link first;

    public void LinkList() {
        first = null;
    }
    public boolean isEmpty() {
        return (first == null);
    }
    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link find(int key) {
        Link current = first;
        while (current.iData != key) {
            if (current.next == null) {
                return null;
            }
            else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;

        while (current.iData != key) {
            if (current.next == null) {
                return null;
            }
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next; //
        }
        //дописать
        return null;

    }

    public Link deletefirst() {
        Link temp = first;
        first = first.next; //удаление, first ссылка на второй элемент
        return temp; //возвращает удаленный элемент
    }
    public void displayList() {
        System.out.println("List (first --> last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;

        }
        System.out.println("");
    }

}
