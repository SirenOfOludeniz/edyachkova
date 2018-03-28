package ru.job4j.test;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TestDoubleFindTest {
    @Test
    public void findDoubleTest() {
        TestDoubleFind test = new TestDoubleFind();
        int[] array = new int[50];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            array[index++] = i;
        }
        int expected = test.doubleFind(array, 9);
        assertThat(expected, is(9));
    }

}