package ru.job4j.listinmap;
import java.util.HashMap;
import java.util.List;
public class UserConvert {
    /**
     * //        for (int i = 0; i < list.size(); i++) {
     //            map.put((list.get(i).getId()),(list.get(i)));
     //        }
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User user : list) {
            map.put(user.getId(), user);
        }
        return map;
    }
}
