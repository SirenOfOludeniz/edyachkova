package ru.job4j.jmm;

public class ThreadClass implements Runnable{
    ShareObject object1 = new ShareObject();

    @Override
    public void run() {
        addToInt();
        addToUniqueShareObject();
    }
    public void addToInt() {
        object1.age += 3;
        System.out.println("age " + object1.age);

    }

    public void addToUniqueShareObject() {
        ShareObject.unique.amount += 5;
        System.out.println("amount " + ShareObject.unique.amount);
    }

    public static void main(String[] args) {
        ThreadClass threadClass1 = new ThreadClass();

        Thread thread = new Thread(threadClass1);
        thread.start();
       /* try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        Thread thread1 = new Thread(threadClass1);
        thread1.start();
       /* try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        System.out.println("age from psvm " + threadClass1.object1.age);
        System.out.println("amount from psvm " + ShareObject.unique.amount);

    }
}
