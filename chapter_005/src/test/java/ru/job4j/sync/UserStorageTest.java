package ru.job4j.sync;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserStorageTest {
    private class StorageThreadA extends Thread{
        private final UserStorage storage;
        private User user;
        private User user2;
        private User user3;


        private StorageThreadA(final UserStorage store, User user) {
            this.user = user;
            this.storage = store;
            this.user2 = new User(2, 300);
            this.user3 = new User(3, 400);
            this.storage.add(user2);
            this.storage.add(user3);
        }

        public void run() {
           this.storage.add(this.user);
        }
    }
    private class StorageThreadB extends Thread {
        private final UserStorage storage;



        private StorageThreadB(final UserStorage store) {
            this.storage = store;

        }
        public void run() {

            this.storage.transfer(2, 3, 200);
        }
    }

    private class StorageThreadC extends Thread {
        private final UserStorage storage;
        private User user1;
        private User user2;
        private User user3;


        private StorageThreadC(final UserStorage store, User user1, User user2, User user3) {
            this.storage = store;
            this.user1 = user1;
            this.user2 = user2;
            this.user3 = user3;
            this.storage.add(user3);
        }
        public void run() {
            this.storage.transfer(3, 2, 100);
            this.storage.add(user1);
            this.storage.update(user2);
           this.storage.delete(user3);

        }
    }
    @Test
    public void storageTest() throws InterruptedException{
        UserStorage storage = new UserStorage();
        StorageThreadA threadA = new StorageThreadA(storage, new User(1, 300));
        StorageThreadB threadB = new StorageThreadB(storage);
        StorageThreadC threadC = new StorageThreadC(storage, new User(4, 100), new User(4, 200), new User(5, 100));
        threadA.start();
        threadB.start();
        threadC.start();
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("Пользователи: " + storage.getUsers());

        /**проверка, обновился ли пользователь с id 4**/
        assertThat(storage.getUsers().get(4).getAmount(), is(200));
        /**проверка, переведены ли 200 со счета пользователя с айди2 на счет пользователя с айди3 в одном потоке
         *а потом в другом потоке, перевели с 3 на счет 2 => 100 **/
        assertThat(storage.getUsers().get(2).getAmount(), is(200));
        assertThat(storage.getUsers().get(3).getAmount(), is(500));

    }

}