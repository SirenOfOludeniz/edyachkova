package ru.job4j.max;
@Test
public class MaxTest {
public void whenFirstLessSecond() {
    Max maxim = new Max();
    int result = maxim.max(1, 2);
    assertThat(result, is(2));
}


}