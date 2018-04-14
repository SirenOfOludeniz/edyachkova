package lafore.algorithm.sorting;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class SortByChoiceTest {
    @Test
    public void choiceSortTest() {
        SortByChoice sortByChoice = new SortByChoice();
        int[] array = {3, 100,1,40, 29 ,5,11, 0, -4};
        int[] result = sortByChoice.sortChoice(array);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}