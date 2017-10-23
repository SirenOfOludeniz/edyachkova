package ru.job4j.Task_chapter2;
import org.testng.annotations.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TrackerTest {
    @Test
    public void WhenAddItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("brbr","Televizor", "Pochnit telik", 23102017, "horosho");
        tracker.add(item1);
        assertThat(tracker.findAll()[0],is(item1));
    }

}
















































