package ru.job4j.taskchapter2;

import org.junit.Test;
//import org.testng.annotations.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
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
    public void updateTest() {
        Tracker tracker1 = new Tracker();
        Item previous = new Item("Radio", "Radio remont", "Zamena tranzistora", 23102017, "brbr");
         tracker1.add(previous);
        Item next = new Item("RadioNext", "Radio repair", "Change tranzistor", 23102017, "frfr");
       //tracker1.add(next);
        next.setId(previous.getId()); //проставляем в новую заявку next id из старой заявки privious. в заявке next было id "RadioNext" стало "Radio"
        // т.е. id это связь между старой заявкой и новой.
        tracker1.update(next); //по id в next мы найдем заявку с таким же id previous и заменим previous на next
       // System.out.println(previous.getId());
       // System.out.println(next.getId());
        //System.out.println("findbyId previous " + tracker1.findById(previous.getId()));
       // System.out.println("findById next " + tracker1.findById(next.getId()));

       assertThat(tracker1.findById(previous.getId()).getName(), is("Radio repair")); // проверяем, изменилось ли поле name c Radio revomont на Radio repair

       /* for (int i = 0; i < tracker1.findAll().length ; i++) {
            System.out.println(tracker1.findAll()[i]);
        }*/
       // assertThat(tracker1.findAll().length,is(1));
        //assertThat(tracker1.findAll()[0],is(next));
        //assertThat(tracker1.findByName(next.getName()),is(next));
    }
    @Test
    public void deleteTest() {
        Tracker tracker = new Tracker();
        Item item3 = new Item("1", " TV", "Repair", 27102017, "brbr");
        Item item4 = new Item("2", "Radio", "Repair", 3, "frfr");
        Item item5 = new Item("3", "TV", "R", 4, "frfr");

        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);

        tracker.delete(item3);
       //assertThat(tracker.findById("1"), is(nullValue()));
       // for (int i = 0; i < tracker.findAll().length; i++) {
            //System.out.println(tracker.findAll()[i]);
        //}
        assertThat(tracker.findAll()[0],is(item4));

    }
   @Test
   public void findAllTest() {
     Tracker tracker = new Tracker();
     Item item1 = new Item("R", "Radio", "repair",3, "brbr");
     Item item2 = new Item("T", "TV", "repair", 4, "frfr");
     Item item3 = new Item("N", "Notebook", "repair", 5,"brbr");

     tracker.add(item1);
     tracker.add(item2);
     tracker.add(item3);

       for (int i = 0; i < tracker.findAll().length; i++) {
           System.out.println(tracker.findAll()[i]);
       }

     assertThat(tracker.findAll().length,is(3));
  }
  @Test
    public void findByIdTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("1", "Notebook", "Screen", 4, "brbr");
        tracker.add(item1);
        assertThat(tracker.findById(item1.getId()),is(item1));
  }
  @Test
    public void findByNameTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("1", "TV", "Colors", 5, "brbr");
        Item item1 = new Item("2", "TV", "Screen", 5, "frfr");
        tracker.add(item);
        tracker.add(item1);
      for (int i = 0; i < tracker.findByName("TV").length ; i++) {
          System.out.println(tracker.findByName("TV")[i]);

      }
        assertThat(tracker.findByName(item.getName())[0],is(item));
  }

}
















































