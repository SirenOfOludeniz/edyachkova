package ru.job4j.array;
import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        //System.out.println(Arrays.toString(nums));
       /* for (int i = 0; i < 3 ; i++) { //строка
            for (int j = 0; j <3 ; j++) { //столбец
                System.out.print(nums[i][j]);
            }
           System.out.println();
        }*/
       int[][] result = rotate(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }



    }
    public static int[][] rotate(int[][] array) {
        int[] a = new int[array.length];
        int[] b = new int[array.length];
        for (int i = 0; i < array.length; i++) { //строка
            for (int j = 0; j < array.length ; j++) { //столбец
              array[i][j] = array[j][array.length - i -1];



                /*a[i] = array[(j-i)+i][j];//копируем в обычный массив а двумерный массив из 0 строчки и имеющихся столбцов
                //каждому элементу из массива а присваиваем элементы массива в 0 строке (1,2,3)

                array[i][(array.length-1) -i] = a[i];//вставляем массив в последний столбец матрицы
                b[i] = array[array.length - 1 -i][j]; //в массив b копируем массив из последней строчки (789)
                array[i][j] = b[i]; // в*/



            }
        } return array;
    }
}
