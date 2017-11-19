package ru.job4j.patternstrategy;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
public class StrategyTest {

    @Test
    public void SquareTest() {
        Square square = new Square();
        final String line = System.getProperty("line.separator");
        String expected = String.format("*****%s*****%s*****%s*****%s*****%s", line, line, line, line, line);
        assertThat(square.pic(), is(expected));
    }
    @Test
    public void TriangleTest() {
        Triangle triangle = new Triangle();
        final String line = System.getProperty("line.separator");
        String expected = String.format("*%s**%s***%s****%s*****%s", line, line, line, line, line);
        assertThat(triangle.pic(), is(expected));
    }
    @Test
    public void PaintTest() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        final String line = System.getProperty("line.separator");
        String expected = String.format("*****%s*****%s*****%s*****%s*****%s%s", line, line, line, line, line, line);
        assertThat(new String(out.toByteArray()), is(expected));

    }











}
