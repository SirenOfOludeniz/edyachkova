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
        if (numbers[index] % 2 == 0) {
            result = true;
        }
        else {
            for (int i = index; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0) {
                    count++;
                }
            }
            if (count > 0) {
                result = true;
            }
            else result = false;

        }
        return result;
    }

    @Override
    public Integer next() {
        for (int i = index; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
               index = i;
               break;
            }
        }
        if (numbers[index] %  2 != 0) {
            throw new NoSuchElementException();
        }
        return numbers[index++];
    }
}
