package ru.job4j.convertation;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    /**
     * @param array
     * @return
     * // первые скобки отвечают за ряды(строки), а вторые - за колонки
    //  int rows = a.length;
    //  int columns = a[0].length;
     *
     *
     */
    public List<Integer> toList(int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int[] a : array) {
            for (int b : a) {
                list.add(b);
            }
        }
        return list;

    }
    public int[][] toArray2(List<Integer> list, int rows) {
        int columns = 0;
        int zeros = (rows * columns) - list.size();
        if ((list.size() % rows) == 0) {
            columns = list.size() / rows;
        } else {
            columns = (list.size() / rows) + 1;
            for (int i = 0; i < zeros; i++) {
                list.add(0);
            }
        }
        int[][] array = new int[rows][columns];
        for (int value : list) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    array[i][j] = value;
                }
            }
        }
        return array;
    }

    public int[][] toArray(List<Integer> list, int rows) {
        int remainder = list.size() % rows;
        int columns = 0;
        int amount0 = 0;
        if (remainder == 0) {
            columns = list.size() / rows;
        }
        if (remainder != 0) {
          int kratnoe = list.size() / rows;
          columns = ((kratnoe + 1) * rows) / rows;
          amount0 = columns - (list.size() % columns);
    }
    int[][] nums = new int[rows][columns];

        if (remainder == 0) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                nums[i][j] = list.get(i + j);
            }
        }
        }

        if (remainder != 0) {
            if (list.size() < (rows * columns)) {
                for (int i = 0; i < amount0; i++) {
                    list.add(0);
                }
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    nums[i][j] = list.get(i + j);
                }
            }


        }
        return nums;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] a : list) {
            for (int b : a) {
                result.add(b);
            }
        }
        return result;
    }
}
