package ru.job4j.taskchapter2;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
public class TrackerSQLTest {
    @Test
    public void checkConnection() {
        Tracker sql = new Tracker();
        assertThat(sql.init(), is(true));
    }
}
