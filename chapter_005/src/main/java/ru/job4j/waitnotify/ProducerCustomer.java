package ru.job4j.waitnotify;

public class ProducerCustomer {

    private final Object lock = new Object();
    private boolean blockCustomer = true;

    public void doSomething() throws InterruptedException{
        synchronized (this.lock) {
            if (this.blockCustomer) { //здесь выполняется работа
                System.out.println("wait");
                lock.wait();
            }
            //to do some useful work
            System.out.println("useful work");
        }

    }
    public void changeBlock(boolean enable) {
        //one more producer
       synchronized (this.lock) {
           System.out.println("enable");
           this.blockCustomer = enable; //здесь меняется состояние
           this.lock.notify();
       }
    }
    public static void main(String[] args) throws InterruptedException{

        final ProducerCustomer blockingWork = new ProducerCustomer();

        Thread producer = new Thread() {
            public void run() {
                blockingWork.changeBlock(false);
            }
        };

        Thread customer = new Thread() {
            public void run() {
                try {
                    blockingWork.doSomething();
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }
        };

        producer.start();
        customer.start();

      /*  //продюсер , тред для выполнения полезной работы, changeBlock()
        new Thread() {
            public void run() {
                blockingWork.changeBlock(false); //будим его
            }
        }.start();
        //customer
        new Thread() {
            public void run() {
                try {
                    blockingWork.doSomething();
                } catch (InterruptedException e) {
                    System.out.println("Thread is interrupt");
                }
            }
        }.start();*/




    }
}
