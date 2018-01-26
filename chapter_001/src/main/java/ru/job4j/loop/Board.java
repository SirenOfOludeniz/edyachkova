package ru.job4j.loop;

public class Board {
    //StringBuilder brbr = new StringBuilder();
    public String paint(int width, int height) {
        StringBuilder brbr = new StringBuilder();
        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) { //поправить тут написать условия прорисовки х и пробелов
                    brbr.append("x");
                    } else {
                       brbr.append(" ");
                    }
                }
            brbr.append(System.lineSeparator());
    }
        return brbr.toString(); }


}