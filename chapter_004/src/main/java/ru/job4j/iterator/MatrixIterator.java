package ru.job4j.iterator;

import java.util.Iterator;

public class MatrixIterator implements Iterator{

    private int[][] arrayIt;
    private int indexRow = 0;
    private int indexColumn = 0;



    public MatrixIterator(int[][] arrayIt) {
        this.arrayIt = arrayIt;
    }

    @Override
    public boolean hasNext() {
        /*boolean result;
        if (indexColumn < arrayIt[indexRow].length) {
            result = true;
        }
        else {
            if (1 + indexRow < arrayIt.length) {
                result = true;
            }
            else result = false;
        }
        return result;*/
       return indexRow < arrayIt.length && indexColumn < arrayIt[indexRow].length;
    }

    @Override
    public Object next() {
        int element = 0;
        if (indexColumn < arrayIt[indexRow].length) {
            element = arrayIt[indexRow][indexColumn++];
        }
        else { indexColumn = 0;
            element = arrayIt[++indexRow][indexColumn++];
        }
        return element;
    }
}
