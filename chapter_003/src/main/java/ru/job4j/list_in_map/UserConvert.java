package ru.job4j.list_in_map;

import java.util.HashMap;
import java.util.List;

public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put((list.get(i).getId()),(list.get(i)));
        }
        return map;
    }
}
