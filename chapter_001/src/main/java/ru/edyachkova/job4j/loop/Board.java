package ru.edyachkova.job4j.loop;

public class Board {
    StringBuilder shax = new StringBuilder();

    public String paint(int width, int height) {
        //StringBuilder shax = new StringBuilder();
        for (int i = 1; i <= height; i++) {
            if (i % 2 != 0) {
                for (int j = 0; j < width; j++) {
                    shax.append("X");
                }
            }
            if (i % 2 == 0) {
                for (int j = 0; j < width; j++) {
                    shax.append("Y");
                }
            }
        }
        return shax.toString();

    }
}
class Result {
    public static void main(String[] args) {
        Board bo = new Board();
        System.out.println(bo.paint(4, 4));
    }
}
