package design.patterns.singleton;

import java.util.ArrayList;

/**
 * Разные объекты создаются
 * создание объекта в статическом методе, приватный конструктор
 */
public class DifferentObjects {
    public static void main(String[] args) {
        ArrayList<MyClass> classes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            classes.add(MyClass.getInstance());
        }
        System.out.println(classes); //здесь РАЗНЫЕ объекты
    }
}
class MyClass {
    private MyClass() {
    }

    public static MyClass getInstance() {
        return new MyClass();
    }
}

