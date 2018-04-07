package ru.job4j.generic;

import ru.job4j.service.SimpleList;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleList<T> simpleList = new SimpleList<>(10);

    public void add(T model) {
        simpleList.add(model);
    }
    public boolean replace(String id, T model) {
        simpleList.set(Integer.parseInt(id), model);
        return true;
    }
    public T findById(String id) {
       return simpleList.get(Integer.parseInt(id));
    }
    public boolean delete(String id) {
        simpleList.delete(Integer.parseInt(id));
        return true;
    }
}
