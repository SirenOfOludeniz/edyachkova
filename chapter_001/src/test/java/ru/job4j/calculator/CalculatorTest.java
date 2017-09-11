package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
	public void whenSubstractThreeMinusOneThenTwo() {
	Calculator calc2 = new Calculator();
    	calc2.substract(3D, 1D);
	double result = calc2.getResult();
	double expected = 2D;
	assertThat(result,is(expected));
	}
	public void whenDivSixDivTwoThenThree() {
    Calculator calc3 = new Calculator();
    calc3.div(6D, 2D);
	double result = calc3.getResult();
	double expected = 3D;
	assertThat(result,is(expected));
	}
	public void whenMultipleThreeMultTwoThenSix() {
	Calculator calc = new Calculator();
    	calc.multiple(3D, 2D);
	double result = calc.getResult();
	double expected = 6D;
	assertThat(result,is(expected));
	}
}