package ru.job4j.lafore2sq;

public class StackX {
    int maxSize;
    int[] stackArray;
    int top;
    public StackX(int s) {
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
    }
    public void push(int j) {
        stackArray[++top] = j;
    }
    public int pop() {
        return stackArray[top--];
    }
    public int peek() {
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
