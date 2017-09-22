package ru.job4j.loop;

import org.junit.Test;
import ru.edyachkova.job4j.loop.Factorial;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
@Test
public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
    Factorial fac = new Factorial();
    int result = fac.calc(5);
    assertThat(result, is(120));
}

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
       Factorial fac2 = new Factorial();
       int result = fac2.calc(0);
       assertThat(result,is(1));
    }







}