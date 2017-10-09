package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class MassiviTest {
    @Test
        public void mas() {
        Massivi fusion = new Massivi();
        int[] massiv1 = {1, 4, 5, 6, 8};
        int[] massiv2 = {2, 3, 4};
        int[] massiv3 = new int[massiv1.length + massiv2.length];

        int[] result = fusion.UnitArray(massiv1, massiv2, massiv3);

        int[] expected = {1, 2, 3, 4, 4, 5, 6, 8};
        assertThat(result,is(expected));
    }
}
