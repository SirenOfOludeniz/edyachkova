package ru.job4j.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {
    ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public synchronized void executeNotification() {
        for (int i = 0; i < 8; i++) {
        this.pool.execute(new Runnable() {
            @Override
            public void run() {
                emailTo(new User("Vasya", "@gmail"));
            }
        });
        }
    }

    public void emailTo(User user) {
        StringBuilder subject = new StringBuilder();
        subject.append("Notification ").append(user.username)
                .append(" to email ").append(user.email);

        StringBuilder body = new StringBuilder();
        body.append("Add a new event to ").append(user.username);

        send(subject.toString(), body.toString(), user.email);

    }

    public void send(String suject, String body, String email) {

    }

}
