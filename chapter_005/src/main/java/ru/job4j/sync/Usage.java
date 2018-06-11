package ru.job4j.sync;

public class Usage {
    public static final class Counter {
        long count = 0;
        final Object lock = new Object(); //создание объекта монитора искусственным путем
        //synchronized(this.lock)

        public void add(long value) {
            synchronized (this) {
                this.count+= value;
            }
        }
    }
    public static final class CounterThread extends Thread {
        protected final Counter counter;

        public CounterThread(final Counter counter) {
            this.counter = counter;
        }

      public void run() {
            counter.add(1);
      }
        /*public void run() {
            synchronized (this.counter) {
                counter.add(1);
            }
        }*/ //если мы работает с одним и тем же объектом,
        //мы его должны заблокировать
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread threadA = new CounterThread(counter);
        Thread threadB = new CounterThread(counter);

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println(counter.count);
    }
}
