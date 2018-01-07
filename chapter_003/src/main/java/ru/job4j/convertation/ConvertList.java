package ru.job4j.convertation;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public List<Integer> toList(int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();
       // первые скобки отвечают за ряды(строки), а вторые - за колонки
      //  int rows = a.length;
      //  int columns = a[0].length;
        for (int[] a : array) {
            for (int b : a) {
                list.add(b);
            }
        }
        return list;

    }
    public int[][] toArray(List<Integer> list, int rows) {
        int remainder = list.size()%rows;
        int columns = 0;
        int amount0 = 0;
        if (remainder == 0) {
            columns = list.size()/rows;
        }
        if (remainder != 0) {
          int kratnoe = list.size()/rows;
          columns = ((kratnoe + 1) * rows)/rows;
          amount0 = columns - (list.size()%columns);
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
            if (list.size() < (rows*columns)) {
                for (int i = 0; i < amount0 ; i++) {
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

   /* public static void main(String[] args) {
        int[][] nums = {{2,3,4},{3,5,6},{2,3}};    //new int[2][5];
        int[] nums2 = {3,4,5,3};
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> numbers2 = new ArrayList<>();
        for (int a : nums2) {
            numbers2.add(a);
        }
        System.out.println(numbers2);
        for (int[] a : nums) {
            for (int b : a) {
                numbers.add(b);
            }
        }
        System.out.println(numbers);
        int rows = 3;
        int amount = numbers.size()/rows;
        int rem = 5%2;
        System.out.println("rem " + rem);
        ArrayList<Integer> chisla = new ArrayList<>();
        for (int i = 0; i < 5 ; i++) {
            chisla.add(10);
        }
        System.out.println("chisla(8) " + chisla.get(8));

    }*/
   /*public static void main(String[] args) {
       ArrayList<Integer> numbers = new ArrayList<>();
       for (int i = 0; i < 9 ; i++) {
           numbers.add(5);
       }
       // теперь нужно добавить список в массив int[3][3]
       int[][] aaaaa = new int[3][3];

      // куда можно записать ArrayList
       for (int a : numbers) {
           for (int i = 0; i < 3 ; i++) {
               for (int j = 0; j < 3 ; j++) {
                   aaaaa[i][j] = a;
               }
           }
       }

   }*/
}
