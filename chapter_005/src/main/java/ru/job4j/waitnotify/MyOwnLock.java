package ru.job4j.waitnotify;

public class MyOwnLock {
    private boolean free = true;

    public void lock() throws InterruptedException{
        synchronized (this) {
        while (!this.free) { //или здесь while должен быть или if? в чем разница?
            wait();
        }
        this.free = false;
            //to do something
        }
    }
    public void unlock() {
        synchronized (this) {
            this.free = true;
            notify();
        }
    }
}
