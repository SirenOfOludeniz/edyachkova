package ru.job4j.patternstrategy;

public class Square implements Shape {
    public String pic() {
        StringBuilder square = new StringBuilder();
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j < 5 ; j++) {


                square.append("*");
            }
            square.append(System.lineSeparator());
        }
        return square.toString();
    }
}
