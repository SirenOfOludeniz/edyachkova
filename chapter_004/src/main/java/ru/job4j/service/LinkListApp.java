package ru.job4j.service;

public class LinkListApp {
    public static void main(String[] args) {
        LinkList theList = new LinkList();
        theList.insertFirst(3, 4);
        theList.insertFirst(3, 6);
        theList.insertFirst(2, 6);
        theList.insertFirst(5, 7);

        theList.displayList();

        while (!theList.isEmpty()) {
            Link alink = theList.deletefirst();
            System.out.println("Deleted ");
            alink.displayLink();
            System.out.println(" ");
        }
        theList.displayList();
    }




}
