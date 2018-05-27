package design.patterns.singleton;

import java.util.ArrayList;

/**
 * инициализация статической переменной в приватном конструкторе
 * так не делается , поэтому будет null
 */
public class InizStaticVariableInConstructorNull {
    public static void main(String[] args) {
        ArrayList<MyOwnClass> classes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            classes.add(MyOwnClass.uniqueObject);
        }
        System.out.println(classes); //будет 5 null. статики в конструкторе не инициализируются (по словам Игоря)
    }
}
class MyOwnClass {
    public static MyOwnClass uniqueObject;
    private MyOwnClass() {
        uniqueObject = new MyOwnClass();
    }
   
}
