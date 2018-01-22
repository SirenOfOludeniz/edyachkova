package ru.job4j.loop;

public class FullPyramideTwoLoops {
    private static final int MIDDLE = 5;

    public static void main(String[] args) {
        int width = 0;
        while (width < MIDDLE) {
            for (int i = 0; i < MIDDLE - width; i++) {
                System.out.print(" ");  // поставьте здесь вместо пробела i, чтобы проверить, что середина на 20-м символе
            }
            for (int i = 0; i < width * 2 + 1; i++) {
                System.out.print("*");
            }
            System.out.println();
            width++;
        }
    }
}
