package ru.job4j.list_in_map;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TestUserConvert {
    @Test
    public void processTest() {
        UserConvert userConvert = new UserConvert();
        User user = new User();
        user.setId(34);
        User user1 = new User();
        User user2 = new User();
        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        HashMap<Integer, User> map = new HashMap<>();
        map = userConvert.process(list);
        assertThat(map.get(34), is(user));

    }
}






















