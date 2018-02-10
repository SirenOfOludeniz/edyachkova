package ru.job4j.peerreview;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
public class Bank {
    private TreeMap<User, ArrayList<Account>> treemap = new TreeMap<>();
    public void addUser(User user) {
        this.treemap.put(user, new ArrayList<>());
    }
    public void delete(User user) { //delete User
        this.treemap.remove(user);
    }

    /**
     *
     * @param user
     * @param account
     * //add User`s account
    //получает значение ArrayList<Account> по ключу user
    //и добавляет в ArrayList элемент account
     */
    public void add(User user, Account account) {
        this.treemap.get(user).add(account);
    }
    private Account getActualAccount(User user, Account account) {
        ArrayList<Account> accounts = this.treemap.get(user);
        return accounts.get(accounts.indexOf(account));
    }
    public void deleteAccount(User user, Account account) {
        this.treemap.get(user).remove(account);
    }
    public List<Account> getAccounts(User user) {
        return this.treemap.get(user);
    }
    public boolean transfer(User user1, Account account1,
                                 User user2, Account account2, double amount) {
        return this.treemap.get(user1).contains(account1)
                && this.treemap.get(user2).contains(account2)
                && getActualAccount(user1, account1).transfer( //здесь метод transfer из класса Account
                getActualAccount(user2, account2), amount);
    }
    public boolean transferVariant2(User user1, Account account1, User user2, Account account2, double amount) {
        return this.treemap.get(user1).contains(account1)
                && this.treemap.get(user2).contains(account2)
                && account1.transfer(account2, amount);
    }
    public String toString() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}