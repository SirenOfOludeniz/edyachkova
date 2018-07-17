package ru.job4j.waitnotify;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    private final Queue<Runnable> tasks = new LinkedBlockingQueue<>();
    private volatile boolean isRunning = true;

    public ThreadPool(Thread A, Thread B) {
        threads.add(new ThreadForPoolA(tasks));
        threads.add(new ThreadForPoolB(tasks));
    }

    public void work(Runnable job) {
        if (isRunning) {
            tasks.offer(job);
        }
        if (this.tasks.size() == 1) {
            notifyAll();
        }

    }

    public void shutdown() {
        this.isRunning = false;
    }


    private final class ThreadForPoolA extends Thread {
        final Queue<Runnable> tasks;

        public ThreadForPoolA(final Queue<Runnable> queue) {
            this.tasks = queue;
        }

        public void run() {
            if (this.tasks.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }
            while (!tasks.isEmpty() && isRunning) {
                Runnable task = tasks.poll();
                if (task != null) {
                    task.run();
                }
            }

        }
    }


    private final class ThreadForPoolB extends Thread {
        final Queue<Runnable> tasks;

        public ThreadForPoolB(final Queue<Runnable> queue) {
            this.tasks = queue;
        }

        public void run() {
            if (this.tasks.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }
            while (!tasks.isEmpty() && isRunning) {
                Runnable task = tasks.poll();
                if (task != null) {
                    task.run();
                }
            }

        }
    }
}

