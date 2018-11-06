package hh.task;

public class TestInsertSortWithNegativeNumber {
    public static void main(String[] args) {
        int[] a = {0,1,2,5,4,7,3,-1};
        TestInsertSortWithNegativeNumber test = new TestInsertSortWithNegativeNumber();
        test.sort(a);

        for (int b : a) {
            System.out.println(b);
        }

    }
    public void sort(int[] array) {
        int in, out;
        for ( out = 0; out < array.length; out++) {
            int temp = array[out];
            in = out;
            while (in > 0 && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
    }
}
