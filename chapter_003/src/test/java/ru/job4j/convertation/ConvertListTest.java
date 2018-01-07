package ru.job4j.convertation;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class ConvertListTest {
    @Test
    public void toListTest() {
        ConvertList convertList = new ConvertList();
        int[][] nums = {{2,3,4}, {3,4,5}, {5,4,3}};
        int result = convertList.toList(nums).get(0);
        assertThat(result, is(2));
    }
    @Test
    public void toArrayTest() {
        ConvertList convertList = new ConvertList();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8 ; i++) {
            list.add(i);
        }
        int rows = 3;
        int result = convertList.toArray(list, rows)[0][2];
        assertThat(result, is(2));
    }
    @Test
    public void convertTest() {
        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{2,3,5});
        list.add(new int[]{4,5});
        list.add(new int[]{3,4,2,5});
        int result = convertList.convert(list).size();
        assertThat(result, is(9));
    }
}
