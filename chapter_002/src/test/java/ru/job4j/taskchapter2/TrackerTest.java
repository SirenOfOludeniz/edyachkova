package ru.job4j.taskchapter2;

import org.junit.Test;
//import org.testng.annotations.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TrackerTest {
    @Test
    public void whenAddItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("brbr", "Televizor", "Pochnit telik", 23102017, "horosho");
        Item resultItem = tracker.add(item1);
        Item expectedItem = item1;

        assertThat(resultItem, is(expectedItem));
    }
    @Test
    public void updateIteme() {
        Tracker tracker1 = new Tracker();
        Item privious = new Item("Radio", "Radio revomont", "Zamena tranzistora", 23102017, "brbr");
         tracker1.add(privious);
        Item next = new Item("RadioNext", "Radio repair", "Change tranzistor", 23102017, "frfr");
        next.setId(privious.getId()); //проставляем в новую заявку next id из старой заявки privious. в заявке next было id "RadioNext" стало "Radio"
        // т.е. id это связь между старой заявкой и новой.
        tracker1.update(next); //по id в next мы найдем заявку с таким же id previous и заменим previous на next
        assertThat(tracker1.findById(privious.getId()).getId(), is("Radio"));
    }
    @Test
    public void deleteTest() {
        Tracker tracker = new Tracker();
        Item item3 = new Item();
        tracker.add(item3);
        tracker.delete(item3);
        assertThat(tracker.findById(item3.getId()), is(null));

    }

}
















































