package ru.job4j.array;

import javafx.scene.transform.Rotate;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArRotateTest {

    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 2 на 2.
        ArRotate arrr = new ArRotate();
        int urr[][] ={{1,2},{3,4}};
        int result[][] = arrr.rotate(urr);
        int expected[][] = {{3,1},{4,2}};
        assertThat(result,is(expected));
    }

    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 3 на 3.
        ArRotate frfr = new ArRotate();
        int trrr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int result[][] = frfr.rotate(trrr);
        int expected[][] = {{7,4,1},{8,5,2},{9,6,3}};
        assertThat(result,is(expected));
    }




}
