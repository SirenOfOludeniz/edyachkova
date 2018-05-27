package design.patterns.singleton;

import java.util.ArrayList;

/**
 * Гарантированный единственный экземпляр, который будет создран до того, как
 * какой-либо поток сможет обратиться к статической перменной uniqueInstance.
 * Без синхронизации.
 */
public class SingletonWithoutSync {
    public static void main(String[] args) {
        ArrayList<Singleton2> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(Singleton2.getInstance());
        }
        System.out.println(list);
    }
}
class Singleton2 {
    private static Singleton2 uniqueInstance = new Singleton2();

    private Singleton2() {

    }
     public static Singleton2 getInstance() {
        return uniqueInstance;
     }
}
