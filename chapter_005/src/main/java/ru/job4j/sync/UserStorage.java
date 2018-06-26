package ru.job4j.sync;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
@ThreadSafe
public class UserStorage {


    @GuardedBy("this")
    private HashMap<Integer, User> users = new HashMap<>();

    public synchronized HashMap<Integer, User> getUsers() {
        return users;
    }
    public boolean containUnique(int id) {
        boolean result = true;
        synchronized (this) {
            for (Map.Entry<Integer, User> pair : this.users.entrySet()) {
                if (id == pair.getValue().getId()) {
                    result = false;
                }
            }
        }
        return result;
    }


    public boolean add(User user) {
        synchronized (this) {
        if (containUnique(user.getId())) {
                users.put(user.getId(), user); }
       return containUnique(user.getId());
        }
    }
    public boolean update(User user) {
        synchronized (this) {
            if (!containUnique(user.getId())) {
                this.users.remove(user.getId());
                this.users.put(user.getId(), user);
            }
            return !containUnique(user.getId());
        }
    }

    public synchronized boolean delete(User user) {
        if (!containUnique(user.getId())) {
            this.users.remove(user.getId());
        }
        return !containUnique(user.getId());
    }

    public void transfer(int fromId, int toId, int amount) {
        synchronized (this) {
            User fromUser = this.users.get(fromId);
            User toUser = this.users.get(toId);
            if (fromUser.getAmount() >= amount) {
                this.users.get(fromId).setAmount(fromUser.getAmount() - amount);
                this.users.get(toId).setAmount(toUser.getAmount() + amount);
            }
        }
    }
}
