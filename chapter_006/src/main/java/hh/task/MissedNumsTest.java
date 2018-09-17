package hh.task;

import java.util.ArrayList;

public class MissedNumsTest {
    public ArrayList<Integer> find(int[] result) {

        ArrayList<Integer> missedNums = new ArrayList<>();
        int size = result.length;

        for (int i = 0; i < size; i++) {
            if (i + 1 < size) {
                int difference = result[i + 1] - result[i];
                if (difference > 1) {
                    for (int j = 1; j < difference; j++) {

                            missedNums.add(result[i] + j);
                    }
                }
            }
        }
        return missedNums;
    }

    public static void main(String[] args) {
        int[] array = {3, 6,7, 8, 12};
        MissedNumsTest mis = new MissedNumsTest();
        System.out.println(mis.find(array));
    }
}
