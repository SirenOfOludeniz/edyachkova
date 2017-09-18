package ru.job4j.loop;

public class Board {
    StringBuilder brbr = new StringBuilder();
    public void paint(int width, int height) {
        for (int i = 1; i < height ; i++) {
            if(i % 2 != 0) {
                for (int j = 0; j < width ; j++) {
                    brbr.append("X");
                }
            }
            if(i%2==0) {
                for (int j = 0; j < width ; j++) {
                    brbr.append("Y");
                }
            }

        }
    }
}
class TestBoard {
    public static void main(String[] args) {
        Board b = new Board();
        b.paint(5,5);
        String a = b.toString();
        System.out.println(a);
    }
}