package ru.job4j.sync;

public class DeadLockProblem {
    public static final class Counter {
        long count = 0;

        public void add(long value) {
            synchronized (this) {
                this.count+= value;
            }
        }
        /*public synchronized void sum(final Counter a, final Counter b) {
            a.add(b.count);
        }*/ //так неправильно, ни один объект не заблокируется
        //Deadlock
        public void sum(final Counter a, final Counter b) {
            synchronized (a) {
                synchronized (b) {
                    System.out.println(a.count + " " + b.count);
                    a.add(b.count);
                }
            }
        }
    }
    public static final class CounterThread extends Thread {
        protected final Counter counterA;
        protected final Counter counterB;

        public CounterThread(final Counter counterA, final Counter counterB) {
            this.counterA = counterA;
            this.counterB = counterB;
        }

        public void run() {
            counterA.sum(counterA, counterB);
           // System.out.println("run is started");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counterA = new Counter();
        counterA.add(1);
        Counter counterB = new Counter();
        counterB.add(2);
        Thread threadA = new CounterThread(counterA, counterB);
        Thread threadB = new CounterThread(counterB, counterA);

       // System.out.println("threadA.start()");
        threadA.start();
        //System.out.println("threadB.start()");
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println(counterA.count);
    }
}
