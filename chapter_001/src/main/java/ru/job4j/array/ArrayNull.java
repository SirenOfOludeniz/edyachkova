package ru.job4j.array;
import java.util.Arrays;
public class ArrayNull {

    public static void main(String[] args) {
        int[] nums = {1,4,0,2,7,0,3,0,2,0};// не можем сделать пустые null элементы, используем 0
        int[] numw1 = sort(nums);
        for (int i = 0; i < numw1.length ; i++) {
            System.out.println(numw1[i]);

        }

    }

    public static int[] sort(int[] nums) {
        int[] copynums = new int[nums.length];
        for (int origin = 0, copy = 0; origin < nums.length ; origin++) {
            if(nums[origin] != 0) {
                copynums[copy] = nums[origin];
                copy++;
            }

        }
        return copynums;
    }
















    /*public static int[] sort(int[] nums) {
        int a; int counter = 0; int counter2 = 0; int b;
        int unique = nums.length;
        for (int i = 0; i < unique; i++) {

               if(nums[i] == 0 /*&& nums[unique -1] != 0) {
                   /* a = nums[i];
                    nums[i] = nums[unique -1];
                    nums[unique-1] = a;
                    unique--;
                    counter++;
            }
        }*/
       /* int[] newnums = Arrays.copyOf(nums,nums.length - counter);

        for (int i = 0; i < newnums.length; i++) {
            if(newnums[i] == 0) {
                b = newnums[i];
                newnums[i] = newnums[newnums.length-1-i];
                newnums[newnums.length-1-i] = b;
                counter2++;
            }
        }
        int[] nnums = new int[newnums.length - counter2];
        for (int i = 0; i < nnums.length ; i++) {
            if(newnums[i] != 0) {
                nnums[i] = newnums[i];
            }

        }

       /* for (int i = 0; i < newnums.length ; i++) {
            if(newnums[i] == 0) {
                a = newnums[i];
                newnums[i] = newnums[newnums.length -1 -i];
                newnums[newnums.length -1-i] = a;
                counter2++;
            }}*/


        /*return  nnums/*Arrays.copyOf(newnums,newnums.length -counter2);
    }*/
}
