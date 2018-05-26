package lafore.algorithm.sorting;

public class SortByInsert {
    public int[] sort(int[] array) {
        int tmp;
        for (int i = 0; i < array.length - 1; i++) {
            if ( array[i] > array[i + 1]) {
                tmp = array[i + 1];
                for (int j = i; j >= 0; j--) {
                    if (j != 0 && array[j] > tmp) {
                        array[j + 1] = array[j];
                    }
                    else {
                        if (j == 0) {
                            array[j + 1] = array[j];
                            array[0] = tmp;
                        }
                        else {
                            array[j + 1] = tmp;
                            j = -1;
                        }
                    }
                }
            }
        }

        return array;
    }

    public int[] sort2(int[] array) {
        int tmp;
        for (int i = 0; i < array.length - 1; i++) {
            if ( array[i] > array[i + 1]) {
                tmp = array[i + 1];
                for (int j = i; j >= 0; j--) {
                    if (array[j] > tmp) {
                        array[j + 1] = array[j];
                        if (j == 0) {
                            array[j] = tmp;
                        }
                    }
                    else {
                        array[j + 1] = tmp;
                        j = -1;
                    }
                }
            }
        }

        return array;
    }



    public int[] laforeSort(int[] a) {
        int in, out;
        for (out = 1; out < a.length; out++) {
            int temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                in--;
            }
            a[in] = temp;

        }
        return a;
    }
}
