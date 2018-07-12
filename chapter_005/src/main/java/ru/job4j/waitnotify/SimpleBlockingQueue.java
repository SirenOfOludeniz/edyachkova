package ru.job4j.waitnotify;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

   // @GuardedBy("this")
    private volatile Queue<T> queue = new LinkedList<>();
    private final Object lock = new Object();
    volatile int count = -1;
    public void offer(T value) throws InterruptedException {
        synchronized (this.lock) {
            if (this.count > 9) {
                System.out.println("wait");
                this.lock.wait();
            }
            queue.offer(value);
            ++count;
            System.out.println("добавлен " + count + "й элемент");

        }

    }

    public T poll() throws InterruptedException {
        synchronized (this.lock) {
        if (queue.isEmpty()) {
            this.lock.wait();
        }
        queue.poll();
            System.out.println("извлекли элемент" + count);
            count--;
        if (this.count == 8) {
            System.out.println("notify");
            this.lock.notify();
        }
            return null;
        }

    }

    public static void main(String[] args) {
        final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();

        Thread producer = new Thread("producer") {
            public void run() {
                for (int i = 0; i < 15; i++) {
                    try {
                        queue.offer(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread consumer = new Thread("consumer") { //извлекает данные из очереди

            public void run() {
                for (int i = 0; i < 7; i++) {
                    try {
                        queue.poll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        producer.start();
        consumer.start();

    }



}
