package ru.job4j.iterator;

import java.util.Iterator;

public class MatrixIterator implements Iterator{

    private int[][] arrayIt;
    private int indexRow = 0;
    private int indexColumn = 0;



    public MatrixIterator(int[][] arrayIt) {
        this.arrayIt = arrayIt;
    }


    public int lenghtArray(int[][] arr) {
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i].length - 1; j < arr[i].length; j++) {
                size = size + arr[i].length;
            }
        }
        return size;
    }
    @Override
    public boolean hasNext() {
        boolean result;
        if (indexColumn < arrayIt[indexRow].length) {
            result = true;
        }
        else {
            if (1 + indexRow < arrayIt.length) {
                result = true;
            }
            else result = false;
        }
        return result;
       // return indexRow < arrayIt.length && indexColumn < arrayIt[indexRow].length;
    }

    @Override
    public Object next() {
        if (indexColumn < arrayIt[indexRow].length) {
            return arrayIt[indexRow][indexColumn++];
        }
        else { indexColumn = 0;
            return arrayIt[++indexRow][indexColumn++];
        }
    }
}
