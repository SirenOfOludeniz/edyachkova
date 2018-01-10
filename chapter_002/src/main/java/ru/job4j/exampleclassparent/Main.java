package ru.job4j.exampleclassparent;

public class Main {


    public static void main(String[] args) {
        Animal animal = new Cat();
        Cat cat2 = new Cat();

       // this.super.makenoise();
        cat2.makenoise();
       // animal.makenoise();
        //cat = cat2;
        //cat.makenoise();
       // super.makenoise();
        System.out.println(cat2.ff());
        Cat koshak = new Cat();
        koshak.print();
        Cat.kotan = new Cat();
        Cat.print();
        Cat.kotan.ff();
        koshak.print();
        Cat.print();


    }
}
