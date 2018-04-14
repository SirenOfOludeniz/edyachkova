package lafore.algorithm.sorting;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

public class BubbleSortTest {
    @Test
    public void bubbleSortTest() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {3, 100, 34, 5, 0};
        int[] result = bubbleSort.bubbleSort(array);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    @Test
    public void bubbleSortLaforeTest() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {3, 100, 34, 5, 0};
        int[] result = bubbleSort.bubbleSortFromLafore(array);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}