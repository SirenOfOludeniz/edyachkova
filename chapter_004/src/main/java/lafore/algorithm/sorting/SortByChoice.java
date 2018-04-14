package lafore.algorithm.sorting;

public class SortByChoice {
    public int[] sortChoice(int[] array) {
        int min;
        int tmp;
        for (int i = 0; i < array.length - 1; i++) {
                min = array[i];
            for (int j = i; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];


                    tmp = array[i];
                    array[i] = min;
                    array[j] = tmp;

                }
            }
        }
        return array;
    }
}
