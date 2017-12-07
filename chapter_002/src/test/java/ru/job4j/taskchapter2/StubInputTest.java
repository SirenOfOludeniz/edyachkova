package ru.job4j.taskchapter2;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
public class StubInputTest {
    @Test
    public void whenUserAddItem() {

        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "4", "Tv", "desc", "5", "comment", "y"});// 0 -add item, y = exit, 4 - id, Tv - name итд
        //3 здесь воспринимается как id, 4 как name, Tv = описание итд
        StartUi start = new StartUi(input, tracker);
         start.init();
        System.out.println("id " + tracker.findAll()[0].getId());
         assertThat(tracker.findAll()[0].getName(), is("Tv"));

    }
    @Test
    public void whenUserUpdateItem() {
        Tracker tracker = new Tracker();
        Item olditem = tracker.add(new Item("45", "Tv", "desc", "17", "brbr"));
        tracker.add(olditem);
        Input input = new StubInput(new String[]{"2", "45", "Radio", "desc", "15", "comment", "y"});
        // 2 update, 4 id newitem, 14 id olditem, 0- exit
        StartUi start = new StartUi(input, tracker);
        start.init();
        assertThat(tracker.findById("45").getName(), is("Radio"));

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

        Input input = new StubInput(new String[]{"1", "y"});
        StartUi start = new StartUi(input, tracker);
        start.init();
        assertThat(tracker.findAll().length, is(3));
    }
    @Test
    public void whenUserDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("45", "Tv", "desc", "15", "brbr");
        Item item1 = new Item();
        Item item2 = new Item();

        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);

        Input input = new StubInput(new String[]{"3", "45", "y"});
        StartUi start = new StartUi(input, tracker);
        start.init();
        assertThat(tracker.findAll()[0], is(item1));
    }
    @Test
    public void whenUserChooseFindById() {
        Tracker tracker = new Tracker();
        Item item = new Item("45", "Radio", "desc", "17", "brbr");
        tracker.add(item);

        Input input = new StubInput(new String[] {"5", "45", "y"});
        StartUi start = new StartUi(input, tracker);
        start.init();
        assertThat(tracker.findById("45").getName(), is("Radio"));
    }
    @Test
    public void whenUserChooseFindByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("45", "Tv", "desc", "15", "brbr");
        tracker.add(item);

        Input input = new StubInput(new String[] {"4", "Tv", "y"});
        StartUi start = new StartUi(input, tracker);
        start.init();
        assertThat(tracker.findByName("Tv").length, is(1));
    }
}


















