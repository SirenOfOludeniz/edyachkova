package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer>{
    final int[] numbers;
    int index = 0;

    public EvenNumbersIterator(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        int count = 0;
        boolean result = false;
        if (index >= numbers.length) {
            result = false;
        }
        for (int i = index; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                ++count;
            }
        }
        if (count >= 1) {
            result = true;
        }
        return result;
    }

    @Override
    public Integer next() {
        int element = 0;
        if (hasNext()) {
            for (int i = index; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0) {
                    index = i;
                    break;
                }
            }
            element = numbers[index++];
        }
        else {
            throw new NoSuchElementException();
        }
        return element;
    }
}
