package ru.job4j.lafore2sq;

public class Queue {
    private int maxSize;
    private int[] queArray;
    private int front;
    private int rear;
    private int nItems; //количество элементов

    public Queue(int s) {
        maxSize = s;
        queArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(int j) {
        //вставка в конец очереди
        if (rear == maxSize - 1) {
            rear = - 1;
        }
        queArray[++rear] = j;
        nItems++;
    }
    public int remove() {
        int temp = queArray[front++]; //вот здесь front меняется
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }
    public boolean isEmpty() {
        return (nItems == 0);
    }
    public boolean isFull() {
        return nItems == maxSize;
    }
    public int size() {
        return nItems;
    }
}
