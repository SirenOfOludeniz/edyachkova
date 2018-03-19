package ru.job4j.lafore2sq;

public class StackXApp {
    public static void main(String[] args) {
        StackX theStack = new StackX(10);
        theStack.push(4);
        theStack.push(5);
        theStack.push(7);
        theStack.push('e'); // расширение типа

        while (!theStack.isEmpty()) {
            int value = theStack.pop();
            System.out.println(value);
        }
    }
}
