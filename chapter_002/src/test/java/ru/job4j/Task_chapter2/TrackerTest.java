package ru.job4j.Task_chapter2;
import org.testng.annotations.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TrackerTest {
    @Test
    public void WhenAddItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("brbr","Televizor", "Pochnit telik", 23102017, "horosho");
        Item result_item = tracker.add(item1);
        Item expected_item = item1;

        assertThat(result_item,is(expected_item));
    }
    @Test
    public void UpdateIteme(){
        Tracker tracker1 = new Tracker();
        Item item_current = new Item("Radio", "Radio revomont", "Zamena tranzistora",23102017, "brbr");
         tracker1.add(item_current);
        Item item_new = new Item("RadioNext", "Radio repair", "Change tranzistor", 23102017,"frfr");
        item_new.setId(item_current.getId());
        tracker1.update(item_new);
        assertThat(tracker1.findById(item_current.getId()).getName(),is("RadioNext"));
    }

}
















































