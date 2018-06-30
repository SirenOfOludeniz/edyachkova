package ru.job4j.service;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class DynamicLinkedListMultithreadingTest {
    private class ThreadFirst extends Thread {
        private final DynamicLinkedList<String> list;

        public ThreadFirst(final DynamicLinkedList<String> list, String name) {
            super(name);
            this.list = list;
        }
        public void run() {
            add();
        }
        public void add() {
            for (int i = 0; i < 10; i++) {
                this.list.add(getName() + "element " + i);
            }
        }
    }
    private class ThreadSecond extends Thread {
        private final DynamicLinkedList<String> list;

        public ThreadSecond(final DynamicLinkedList<String> list, String name) {
            super(name);
            this.list = list;
        }
        public void run() {
            add();
        }
        public void add() {
            for (int i = 0; i < 10; i++) {
                this.list.add(getName() + "element " + i);
            }
        }
    }
    @Test
    public void test() throws InterruptedException{
        DynamicLinkedList<String> list = new DynamicLinkedList<>();
        ThreadFirst first = new ThreadFirst(list, "FirstThread");
        ThreadSecond second = new ThreadSecond(list, "SecondThread");

        first.start();
        second.start();

        first.join();
        second.join();

        int count = 0;
        for (String name : list) {
            System.out.println(name);
            ++count;
        }

        assertThat(count, is(20));
    }
}
