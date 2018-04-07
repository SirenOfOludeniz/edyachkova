package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator<Integer> {

    private int[] values;
    private int index = 0;

    public PrimeIterator(int[] values) {
        this.values = values;
    }


    @Override
    public boolean hasNext() {
        boolean result = false;
        int count = 0;
        for (int i = index; i < values.length; i++) {

            int divider = 0;
            System.out.println("ИТЕРАЦИЯ " + i);
            for (int j = 1; j <= values[i]; j++) {
                if (values[i] % j == 0) {
                    System.out.println(values[i] +  " % " + j + "= " + values[i] % j);
                    divider++;
                }
            }
            if (divider == 2) {
                ++count;
            }
            if (count == 1) {
                index = i;
                result = true;
                break;
            }

        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return values[index++];

    }
}
