package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator<Integer>{

    private int[] values;
    private int index= 0;

    public PrimeIterator(int[] values) {
        this.values = values;
    }


    @Override
    public boolean hasNext() {
        boolean result = false;
        int count = 0;
        for (int i = index; i < values.length; i++) {
            int divider = 0;
            for (int j = 1; j <= values[i]; j++) {
                if (values[i] % j == 0) {
                    System.out.println(values[i] +  " % " + j + "= " + values[i] % j);
                    divider++;
                }
                System.out.println("divider from hasNext = " + divider);
            }
            if (divider == 2) {
               ++count;
            }
            if (count > 1) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        int count = 0;

        for (int i = index; i < values.length; i++) {
            int divider = 0;
            for (int j = 1; j <= values[i]; j++) {
                if (values[i] % j == 0) {
                    System.out.println(values[i] +  " % " + j + "= " + values[i] % j);
                    divider++;
                }
            }
            System.out.println("divider from next= " + divider);
            if (divider == 2) {
                index = i;
               break;
            }

        }
        return values[index++];


       /* for (int i = index; i < values.length; i++) {
            if (values[i] > 1 && values[i] % values[i] == 0 && values[i] % 1 == 0) {
                index = i;
                break;
            }
        }
        if (!(values[index] > 1 && values[index] % values[index] == 0 && values[index] % 1 == 0)) {
            throw new NoSuchElementException();
        }
        return values[index++];*/
    }
}
