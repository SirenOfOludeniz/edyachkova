package hh.task;

import java.util.ArrayList;

public class DeleteDublicates {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] ar = {1, 3, 3, 5, 5, 5,7};
        int[] result = new int[ar.length];
        int count = 0;
        for (int a : ar) {
            if (list.indexOf(a) == -1) {
                list.add(a);
                result[count++] = a;
            }
        }

        System.out.println(list);
        for (int b : result) {
            System.out.println(b);
        }

    }
}
