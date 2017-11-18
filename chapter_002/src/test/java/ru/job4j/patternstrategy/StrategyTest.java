package ru.job4j.patternstrategy;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
public class StrategyTest {
    @Test
    public void WhenSpellTriangle() {
        Paint painttriangle = new Paint(new Triangle());
        painttriangle.draw(new Triangle());
        final String line = System.getProperty("line.separator");
        String expected = String.format("*%s**%s***%s****%s*****", line, line, line, line, line);
        assertThat(painttriangle.draw(new Triangle()),is(expected));
    }











}
