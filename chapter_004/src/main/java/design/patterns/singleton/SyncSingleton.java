package design.patterns.singleton;

import java.util.ArrayList;

/**
 * инициализация статической переменной в статическом методе
 * Единственный экземпляр + синхронизация
 */
public class SyncSingleton {
    public static void main(String[] args) {
        ArrayList<Singleton> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(Singleton.getInstance());
        }
        System.out.println(list);
    }
}
class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
