package lafore.algorithm.sorting;

import static org.junit.Assert.*;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortByInsertTest {
    @Test
    public void sortInsertTest() {
        SortByInsert sortByInsert = new SortByInsert();
        //int[] array = {0, 1, 9, 4, 23, -4};
        int[] array = {0, 3, 12, -1, -5, 45, 7};
        int[] result = sortByInsert.sort(array);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
    @Test
    public void sort2() {
        SortByInsert sortByInsert = new SortByInsert();
        int[] array = {0, 3, 12, -1, -5, 45, 7};
        int[] result = sortByInsert.sort2(array);
        for (int a : result) {
            System.out.println(a);
        }
    }

}