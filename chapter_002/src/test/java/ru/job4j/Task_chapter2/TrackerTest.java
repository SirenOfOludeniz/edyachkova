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
        Item result_item = new Item();
        result_item = tracker.add(item1);
        Item expected_item = new Item();
        expected_item = item1;

        assertThat(result_item,is(expected_item));
    }

}
















































