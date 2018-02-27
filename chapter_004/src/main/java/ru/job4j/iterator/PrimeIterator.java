package ru.job4j.iterator;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

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
        int counthasNext = 0;
        for (int i = index; i < values.length; i++) {

            int divider = 0;
            System.out.println("ИТЕРАЦИЯ " + i);
            for (int j = 1; j <= values[i]; j++) {
                if (values[i] % j == 0) {
                    System.out.println(values[i] +  " % " + j + "= " + values[i] % j);
                    divider++;
                }
               // System.out.println("divider from hasNext = " + divider);
            }
            if (divider == 2) {
               ++counthasNext;
            }
            if (counthasNext >= 1) {
                result = true;
            }
            System.out.println("counthasNext = " + counthasNext);
        }
        return result;
    }

    @Override
    public Integer next() {
        //if hasNaxt = false => exception
        System.out.println("index " + index);
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
        if (index >= values.length) {
            throw new NoSuchElementException();
        }
        for (int i = 1; i <= values[index]; i++) {
            //System.out.println("index = " + index);
            if (values[index] % i == 0) {
                ++count;
                System.out.println("count inside = " + count);
            }

        }
        System.out.println("count " + count);
        if (count != 2) {
           throw new NoSuchElementException();
        }

        return values[index++];
    }
}
