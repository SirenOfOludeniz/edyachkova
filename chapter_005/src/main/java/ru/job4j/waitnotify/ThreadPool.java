package ru.job4j.waitnotify;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    private final Queue<Runnable> tasks = new LinkedBlockingQueue<>();

    public void work(Runnable job) {
        tasks.add(job);

    }

    public void shutdown() {

    }
}
class SomeRunnableClassA implements Runnable {

    @Override
    public void run() {

    }
}
class SomeRunnableClassB implements Runnable {

    @Override
    public void run() {

    }
}




class ThreadForPoolA extends Thread{
    final Queue<Runnable> tasks;
    public ThreadForPoolA(final LinkedBlockingQueue<Runnable> queue) {
        this.tasks = queue;
    }
    public void run() {
        for (Runnable runnable : tasks) {
            runnable.run();
        }
    }
}






class ThreadForPoolB extends Thread{
    final Queue<Runnable> tasks;
    public ThreadForPoolB(final LinkedBlockingQueue<Runnable> queue) {
        this.tasks = queue;
    }
    public void run() {
        for (Runnable runnable : tasks) {
            runnable.run();
        }
    }
}

