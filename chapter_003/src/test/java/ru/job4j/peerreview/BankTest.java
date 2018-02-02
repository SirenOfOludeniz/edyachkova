package ru.job4j.peerreview;
import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class BankTest {
    @Test
    public void getActualAccountsTest() {
        Bank bank = new Bank();
        User userVasya = new User();

        Account account23 = new Account(23000, "123");
        Account account34 = new Account(15000, "12");


    }
}
