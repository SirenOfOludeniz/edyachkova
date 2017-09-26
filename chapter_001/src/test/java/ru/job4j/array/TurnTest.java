package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TurnTest {
    @Test
    public void ChetnArray() {
        Turn ar1 = new Turn();
        int[] num = {0,1,2,3,4};
        int[] result = ar1.back(num);
        int[] expected = {4,3,2,1,0};
        assertThat(result, is(expected));
    }
    @Test
    public void NechArray() {
        Turn ar2 = new Turn();
        int[] nums = {0,1,2,3};
        int[] result = ar2.back(nums);
        int[] expected = {3,2,1,0};
        assertThat(result,is(expected));

    }
}