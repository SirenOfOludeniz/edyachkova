package ru.job4j.array;

import java.util.Arrays;

public class Turn {
   /* public static void main(String[] args) {


        int[] nums = new int[5];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 3;
        nums[4] = 4;


        System.out.println(Arrays.toString(back(nums)));
    }*/


    public static int[] back(int[] array) {
        for (int i = 0; i < 2; i++) {
            int a;
            a = array[i];
            array[i] = ((array.length - 1) - i);
            array[((array.length -1) - i)] = a;

        }
            return array;
        }
    }
