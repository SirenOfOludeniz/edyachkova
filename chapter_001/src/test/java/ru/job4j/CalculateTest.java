package ru.job4j;

import org.junit.Test;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Ekaterina Dyachkova (mailto:ekaterina22_01_94@mail.ru)
* @version $Id$
* @since 09.09.2017
*/

public class CalculateTest {
 /**
* Test echo.
*/
@Test
public void whenTakeNameThenTreeEchoPlusName() {
String input = "Petr Arsentev";
String expect = "Echo, echo, echo : Petr Arsentev";
Calculate calc = new Calculate();
String result = calc.echo(input);
assertThat(result, is(expect));
}
}