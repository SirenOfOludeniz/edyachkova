package ru.job4j.array;

public class ArRotate {
    /*public static void main(String[] args) {

            int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};

        int[][] result = rotate(nums);

       for (int i = 0; i < nums.length ; i++) { //строка
            for (int j = 0; j <nums.length ; j++) { //столбец
               // System.out.print(nums[i][j]);
                System.out.print(result[i][j]);
            }
           System.out.println();
        }
    }*/

    public static int[][] rotate(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {

               int a = array[i][j];
              array[i][j] = array[j][i];
             array[j][i] = a;

            }
            array[i] = new Turn().back(array[i]);
        }
        return array;
    }

}
