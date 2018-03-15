package ru.job4j.generic2;

import ru.job4j.service.SimpleList;

public class UserStore extends AbstractStore implements Store<User>{
    // здесь должно быть UserStore<User>
    // но тогда Store<User> подчеркивает красным
    SimpleList<User> simpleList = new SimpleList<>(10);
    @Override
    public void add(User model) {
        simpleList.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        simpleList.set(Integer.parseInt(id), model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        simpleList.delete(Integer.parseInt(id));
        return true;
    }

    @Override
    public User findById(String id) {
        return simpleList.get(Integer.parseInt(id));
    }
}
