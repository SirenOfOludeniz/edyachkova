package ru.job4j.testtask;

import java.util.*;

public class Bank {
    private Map<User, List<Account>> users = new TreeMap<>();

    public Map<User, List<Account>> getUsers() {
        return users;
    }

    public void setUsers(Map<User, List<Account>> users) {
        this.users = users;
    }

    public void addUser(User user) {
        //this.users.put(user, new ArrayList<>());
        this.users.putIfAbsent(user, new ArrayList<>());
    }
    public void deleteUser(User user) {
        this.users.remove(user);
    }
    public void addAccountToUser(String passport, Account account) {
        for (User user : this.users.keySet()) {
            if (user.getPassport().equals(passport)) {
                this.users.get(user).add(account);

            }
        }
    }
    public void deleteAccountFromUser(String passport, Account account) {
        for (User user : this.users.keySet()) {
            if (user.getPassport().equals(passport)) {
                this.users.get(user).remove(account);
                //в задании имелось в виду здесь использовать indexOf?
            }
        }
    }
    public List<Account> getUserAccounts(String passport) {
        List<Account> list = new ArrayList<>();
        for (User user : this.users.keySet()) {
            if (user.getPassport().equals(passport)) {
                list.addAll(this.users.get(user));
            }
        }
        return list;
    }
    public User findUserByPassport(String passport) {
        User user = new User();
        for (User user1 : this.users.keySet()) {
            if (user1.getPassport().equals(passport)) {
                user = user1;
            }
        }
        return user;
    }
    public Account findAccountByRequisites(String passport, String requisites) {
        Account account = new Account();
        for (Account account1 : getUserAccounts(passport)) {
            if (account1.getRequisites().equals(requisites)) {
                account = account1;
            }
        }
        return account;
    }

    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account accountSrc = findAccountByRequisites(srcPassport, srcRequisite);
        Account accountDest = findAccountByRequisites(destPassport, dstRequisite);
        if (amount <= accountSrc.getValue() && this.users.get(findUserByPassport(srcPassport)).contains(findAccountByRequisites(srcPassport, srcRequisite))) {
            accountSrc.setValue(accountSrc.getValue() - amount);
            accountDest.setValue(accountDest.getValue() + amount);
            result = true;
        }
        return result;
    }


}
