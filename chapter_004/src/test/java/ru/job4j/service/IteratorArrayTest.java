package ru.job4j.service;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class IteratorArrayTest {

    public static final class ForEachArray implements Iterable {

        private final int[] values;

        public ForEachArray(final int[] values) {
            this.values = values;
        }

        @Override
        public Iterator iterator() {
            return new IteratorArray(this.values);
        }
    }

    @Test
    public void whenGetNextCallShouldForward() {
        IteratorArray it = new IteratorArray(new int[] {1, 3});

        it.next();
        int result = (int) it.next();

        assertThat(result, is(3));
    }
    @Test
    public void whenCheckNextPositionShouldReturnConstantValue() {
        IteratorArray it = new IteratorArray(new int[] {1});

        it.next();
        it.hasNext();
        boolean result = it.hasNext();
        assertThat(result, is(false));
    }
    @Test
    public void forEach() {
        ForEachArray forEachArray = new ForEachArray(new int[] {1, 4, 5});
        for (Object value : forEachArray) {
            System.out.println(value); //реализация конструкции цикла for-each для любого множества
        }
    }
}