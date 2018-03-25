package ru.job4j.service;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(i + " " + j);
            }
        }
        Whale whale = new Whale();
        whale.printName();

        Cow cow = new Whale();
        cow.printName();
    }
}
class Cow{
    public void printColor() {
        System.out.println("Я = белая");
    }
    public void printName() {
        System.out.println("Корова");
    }

}

class Whale extends Cow{
    public void printName() {
        System.out.println("Я - кит");
    }

}






















