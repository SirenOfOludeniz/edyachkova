package ru.job4j.service;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class DynamicArrayMultithreadingTest {
    private class ThreadFirst extends Thread {
        private final DynamicArray<String> store;

        public ThreadFirst(final DynamicArray<String> store, String name) {
            super(name);
            this.store = store;
        }
        public void run() {
            add();
        }
        public void add() {
            for (int i = 0; i < 10; i++) {
                this.store.add(getName() + "element" + i);
            }
        }
    }
    private class ThreadSecond extends Thread {
        private final DynamicArray<String> store;

        public ThreadSecond(final DynamicArray<String> store, String name) {
            super(name);
            this.store = store;
        }
        public void run() {
            add();
        }
        public void add() {
            for (int i = 0; i < 10; i++) {
                this.store.add(getName() + "element" + i);
            }
        }
    }
    @Test
    public void multiThreadAccessToDynamicArrayTest() throws InterruptedException{
        DynamicArray<String> store = new DynamicArray<>();
        ThreadFirst first = new ThreadFirst(store, "FirstThread");
        ThreadSecond second = new ThreadSecond(store, "SecondThread");

        first.start();
        second.start();

        first.join();
        second.join();

        int count = 0;
        for (String name : store) {
            System.out.println(name);
            ++count;
        }

        assertThat(count, is(20));
    }
}
