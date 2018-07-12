package ru.job4j.waitnotify;

import java.util.LinkedList;
import java.util.Queue;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
public class ProCust {
    @ThreadSafe
    public static final class SimpleBlockingQueue<T> {
         @GuardedBy("this")
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
                if (count == 0) {
                    this.lock.notify();
                }

            }

        }

        public T poll() throws InterruptedException {
            synchronized (this.lock) {
                if (queue.isEmpty()) {
                    this.lock.wait();
                }
                T element = queue.poll();
                System.out.println("извлекли элемент" + count);
                count--;
                if (this.count == 8) {
                    System.out.println("notify");
                    this.lock.notify();
                }
                return element;
            }
        }
    }

    public static final class Producer extends Thread {
        final SimpleBlockingQueue<Integer> queue;

        public Producer(final SimpleBlockingQueue<Integer> queue) {
            this.queue = queue;
        }
        public void run() {
            for (int i = 0; i < 15; i++) {
                try {
                    queue.offer(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static final class Customer extends Thread {
        final SimpleBlockingQueue<Integer> queue;

        public Customer(final SimpleBlockingQueue<Integer> queue) {
            this.queue = queue;
        }
        public void run() {
            for (int i = 0; i < 7; i++) {
                try {
                    queue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException{
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        Producer producer = new Producer(queue);
        Customer customer = new Customer(queue);

        producer.start();
        customer.start();
        producer.join();
        customer.join();
    }



}
