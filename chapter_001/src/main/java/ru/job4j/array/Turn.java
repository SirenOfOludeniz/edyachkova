package ru.job4j.array;

import java.util.Arrays;

public class Turn {
  public static void main(String[] args) {


        int[] nums = new int[9];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 3;
        nums[4] = 4;
        nums[5] = 5;
        nums[6] = 6;
        nums[7] = 7;
        nums[8] = 8;



        System.out.println(Arrays.toString(back(nums)));
  }



    public static int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int a;
            a = array[i];
            array[i] = array[((array.length - 1) - i)];
            array[((array.length - 1) - i)] = a;
        }
            return array;
        }
    }
