package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class ArrayWordInwordTest {
    @Test
    public void WhenDinozavrContainDino() {
        ArrayWordInword primer = new ArrayWordInword();
        String fullword = "Dinozavr";
        String shortword = "Dino";
        boolean except = true;
        boolean result = primer.contains(fullword,shortword);
        assertThat(result,is(except));
    }
}
