package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator{

    private int[][] arrayIt;
    private int indexRow = 0;
    private int indexColumn = 0;



    public MatrixIterator(int[][] arrayIt) {
        this.arrayIt = arrayIt;
    }

    @Override
    public boolean hasNext() {
        boolean result;
        if (indexColumn < arrayIt[indexRow].length) {
            result = true;
        }
        else {
            if (1 + indexRow < arrayIt.length) {
                ++indexRow;
                indexColumn = 0;
                result = true;
            }
            else result = false;
        }
        return result;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return arrayIt[indexRow][indexColumn++];
    }
}
