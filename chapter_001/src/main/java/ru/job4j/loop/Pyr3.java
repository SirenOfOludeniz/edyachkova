package ru.job4j.loop;

public class Pyr3 {
    private static final int MIDDLE = 5;

    public static void main(String[] args) {
        StringBuilder buka = new StringBuilder();
       // int width = 0;
        for (int width = 0; width < MIDDLE; width++) {
            for (int i = 0; i < MIDDLE - width; i++) {
                System.out.print(" ");  // поставьте здесь вместо пробела i, чтобы проверить, что середина на 20-м символе
            }
            for (int i = 0; i < width; i++) {
                System.out.print("*");
            }
            System.out.println();
            //width++;

            /*for (int j = 0; j < width ; j++) {

                System.out.println("^");}*/


        }
        }
    }

