package ru.job4j.peerreview;
import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class BankTest {
    @Test
    public void transferTest() {
        Bank bank = new Bank();
        User userVasya = new User("Vasya");
        User userMasha = new User("Masha");
        Account accountM = new Account(23000, "123");
        Account accountV = new Account(15000, "345");
        bank.addUser(userMasha);
        bank.addUser(userVasya);
        bank.add(userMasha, accountM);
        bank.add(userVasya, accountV);

        bank.transfer(userMasha, accountM, userVasya, accountV, 2000);
        //как теперь проверить счет Васи, что он увеличился на 2000?

        assertThat(accountV.values, is(17000.0));

    }
    @Test
    public void transferVariant2Test() {
        Bank bank = new Bank();
        User userVasya = new User("Vasya");
        User userMasha = new User("Masha");
        Account accountM = new Account(23000, "123");
        Account accountV = new Account(15000, "345");
        bank.addUser(userMasha);
        bank.addUser(userVasya);
        bank.add(userMasha, accountM);
        bank.add(userVasya, accountV);

        bank.transferVariant2(userMasha, accountM, userVasya, accountV, 2000);
        assertThat(accountV.values, is(17000.0));
    }
}
