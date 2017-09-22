package ru.job4j.array;
import org.junit.Test;
import ru.edyachkova.job4j.array.BubleSort;
import ru.edyachkova.job4j.loop.Factorial;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubleSortTest {

        @Test
        public void whenSortArrayWithTenElementsThenSortedArray() {
            BubleSort bub = new BubleSort();
            int[] arr = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
            int[] result = bub.sort(arr);
            int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
            assertThat(result,is(expected));




            //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
        }
    }


