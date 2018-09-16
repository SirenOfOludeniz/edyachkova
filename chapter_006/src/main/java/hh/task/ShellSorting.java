package hh.task;

import jdk.nashorn.tools.Shell;

public class ShellSorting {
    public static void main(String[] args) {
        ShellSorting shellSorting = new ShellSorting();
        int[] nums = {1, 5, 6, 9, 2, 3, 12, 8, -1, 6};
        shellSorting.sort(nums);
        for (int a : nums) {
            System.out.println(a);
        }
    }
    public void sort(int[] array) {
        int inner, outer;
        int temp;
        int nElems = array.length;
        int h = 1;
        while (h <= nElems/3) {
            h = h*3 + 1;

            while (h > 0) {
                for (outer = h; outer < nElems; outer++) {
                    temp = array[outer];
                    inner = outer;

                    while (inner > h - 1 && array[inner - h] >= temp) {
                        array[inner] = array[inner - h];
                        inner -= h;
                    }
                    array[inner] = temp;
                }
                h = (h - 1)/3;
            }
        }
    }
}
