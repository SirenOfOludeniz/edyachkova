package ru.job4j.Task_chapter2;
import org.junit.jupiter.api.Test;
//import org.testng.annotations.Test;
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
        Item privious = new Item("Radio", "Radio revomont", "Zamena tranzistora",23102017, "brbr");
         tracker1.add(privious);
        Item next = new Item("RadioNext", "Radio repair", "Change tranzistor", 23102017,"frfr");
        next.setId(privious.getId());//проставляем в новую заявку next id из старой заявки privious. в заявке next было id "RadioNext" стало "Radio"
        // т.е. id это связь между старой заявкой и новой.
        tracker1.update(next);//по id в next мы найдем заявку с таким же id previous и заменим previous на next
        assertThat(tracker1.findById(privious.getId()).getId(),is("Radio"));
    }

}
















































