package ru.job4j.generic2;


import ru.job4j.service.SimpleList;

public class RoleStore extends AbstractStore implements Store<Role> {
    // здесь должно быть RoleStore<Role>
    // но тогда Store<Role> подчеркивает красным

    SimpleList<Role> simpleList = new SimpleList<>(10);

    @Override
    public void add(Role model) {
        simpleList.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        simpleList.set(Integer.parseInt(id), model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        simpleList.delete(Integer.parseInt(id));
        return true;
    }

    @Override
    public Role findById(String id) {
        return simpleList.get(Integer.parseInt(id));
    }
}
