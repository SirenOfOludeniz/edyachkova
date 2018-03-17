package ru.job4j.lafore;

public class Link {

    public int dData;
    public Link next;
    public Link previous;

    public Link(int d) {
        dData = d;
    }

    public void displayLink() {
        System.out.println(dData + " ");
    }

}
