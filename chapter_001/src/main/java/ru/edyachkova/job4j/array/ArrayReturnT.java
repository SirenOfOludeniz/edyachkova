package ru.edyachkova.job4j.array;

public class ArrayReturnT {
    private int[] values;
    public int[] sort(int[] that) {
        this.values = that;
        return that;
    }
    public void echo() {
        System.out.println(this.values[0]);
    }

    public static void main(String[] args) {
        ArrayReturnT ar = new ArrayReturnT();
         int[] immutable = {1};
         int[] ri = ar.sort(immutable);
        ri[0] = -1;
        ar.echo();
    }
}
