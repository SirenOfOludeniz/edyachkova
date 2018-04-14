package lafore.algorithm.sorting;

public class BubbleSort {
    public int[] bubbleSort(int[] array) {
        int tmp;
        int size = array.length;
        for (int i = 0; i < array.length; i++) {
            size--;
            for (int j = 0; j < size; j++) {
                if ( array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    public int[] bubbleSortFromLafore(int[] array) {
        int nElems = array.length;
        int out, in;
        int tmp;
        for (out = nElems - 1; out > 0; out--) {
            System.out.println("out " + out);
            for (in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    tmp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = tmp;
                }
            }
        }
        return array;
    }
}
