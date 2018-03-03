package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {


    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            Iterator<Integer> iter = it.next();

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (it.hasNext()) {
                    if (iter.hasNext()) {
                        result = true;
                    }
                    else {
                        iter = it.next();
                        System.out.println("iter.hasNext() : " + iter.hasNext());
                        result = iter.hasNext();
                        //result = false;
                    }
                }
                else result = false;

                return  result;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                   // throw new NoSuchElementException();
                }
                if (!iter.hasNext()) {
                    iter = it.next();
                }
                int result = 0;
                result = iter.next();
                System.out.println(result);
                return result;
            }
        };
    }

}
