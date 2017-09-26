package ru.job4j.loop;

public class Paint {
    public String piramid(int h) {
        StringBuilder buka = new StringBuilder();
        for (int i = 1; i <=  h ; i++) { //height

            for (int j = 1; j <= i ; j++) {

            buka.append("^");}

            buka.append(System.lineSeparator());
        }
        return buka.toString();
    }

    public static void main(String[] args) {
        Paint pp = new Paint();
        String result = pp.piramid(5);
        System.out.println(result);
    }


}