package ru.job4j.apphf;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    public List getGuitars() {
        return guitars;
    }

    private List guitars;

    public Inventory() {
        guitars = new LinkedList();
    }

    public void addGuitar(String serialNumber, double price, GuitarSpec guitarSpec) {
        Guitar guitar = new Guitar(serialNumber, price, guitarSpec);
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        Guitar guitar1 = null;
        for (Iterator i = guitars.iterator(); i.hasNext(); ) {
            Guitar guitar = (Guitar)i.next();
            if (guitar.getSerialNumber().equals(serialNumber)) {
                guitar1 = guitar;
            }
        }
        return guitar1; //??
    }

    /*public List search(GuitarSpec searchSpec) {
        return searchSpec.compareGuitarSpec(searchSpec);
    }*/
    public List search(GuitarSpec searchSpec) {
        List matchingGuitars = new LinkedList();
        for (Iterator i = guitars.iterator(); i.hasNext();) {
            Guitar guitar = (Guitar)i.next();
            if (guitar.getSpec().matches(searchSpec)) {
                matchingGuitars.add(guitar);
            }
        }
        return matchingGuitars;
    }
}
