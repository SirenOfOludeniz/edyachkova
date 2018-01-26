package ru.edyachkova.job4j.array;
import java.util.Arrays;
public class BubleSort {
   /* public static void main(String[] args) {
        int[] nums = {3,2,5,1,0};
        //nums = {3,2,5,1,0};
        //int n;
        System.out.println(Arrays.toString(sort(nums))); }*/


        public static int[] sort(int[] array) {
        int n;
            for (int j = 0; j < array.length; j++) {
                for (int i = 0; i < array.length - 1; i++) {

                if (array[i] > array[i + 1]) {
                    n = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = n;
                }
            }
            }
            return array;
        }
}