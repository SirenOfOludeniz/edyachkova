package ru.job4j.lafore;

public class DoublyLinkedApp {
    public static void main(String[] args) {
        DoublyLinkedList theList = new DoublyLinkedList();
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

       /* theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);*/

        theList.displayForward();
       // theList.deleteFirst();


        System.out.println("first " + theList.first.dData);
        System.out.println("last " + theList.last.dData);
    }
}
