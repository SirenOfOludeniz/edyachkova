package hh.task;



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
        int h = 1;
        while (h <= array.length/3) {
            h = h * 3 + 1;
        }
            while (h > 0) {
                for (outer = h; outer < array.length; outer++) {
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
