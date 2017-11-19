package ru.job4j.taskchapter2;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
public class StubInputTest {
    @Test
    public void whenUserAddItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "4", "Tv", "desc", "15112017", "0"});
        // 1 -add item, 0 = exit, 4 - id, Tv - name итд
        StartUi start = new StartUi(input);
         start.menu(tracker);
         assertThat(tracker.findAll()[0].getName(), is("Tv"));

    }
    @Test
    public void whenUserUpdateItem() {
        Tracker tracker = new Tracker();
        Item olditem = tracker.add(new Item("14", "Tv", "desc", 17, "brbr"));
        tracker.add(olditem);
        Input input = new StubInput(new String[]{"3", "4", "Radio", "desc", "15", "14", "0"});
        // 3 update, 4 id newitem, 14 id olditem, 0- exit
        StartUi start = new StartUi(input);
        start.menu(tracker);
        assertThat(tracker.findById("14").getName(), is("Radio"));

    }
    @Test
    public void whenUserChooseFindAll() {
        Tracker tracker = new Tracker();

        Item item = new Item();
        Item item1 = new Item();
        Item item2 = new Item();
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);

        Input input = new StubInput(new String[]{"2", "0"});
        StartUi start = new StartUi(input);
        start.menu(tracker);
        assertThat(tracker.findAll().length, is(3));
    }
    @Test
    public void whenUserDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("3", "Tv", "desc", 15, "brbr");
        Item item1 = new Item();
        Item item2 = new Item();

        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);

        Input input = new StubInput(new String[]{"4", "3", "0"});
        StartUi start = new StartUi(input);
        start.menu(tracker);
        assertThat(tracker.findAll()[0], is(item1));
    }
    @Test
    public void whenUserChooseFindById() {
        Tracker tracker = new Tracker();
        Item item = new Item("5", "Radio", "desc", 17, "brbr");
        tracker.add(item);

        Input input = new StubInput(new String[] {"5", "5", "0"});
        StartUi start = new StartUi(input);
        start.menu(tracker);
        assertThat(tracker.findById("5").getName(), is("Radio"));
    }
    @Test
    public void whenUserChooseFindByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("5", "Tv", "desc", 15, "brbr");
        tracker.add(item);

        Input input = new StubInput(new String[] {"6", "Tv", "Tv", "Tv", "0"});
        StartUi start = new StartUi(input);
        start.menu(tracker);
        assertThat(tracker.findByName("Tv").length, is(1));
    }
}


















