package ru.job4j.patternstrategy;

public class Square implements Shape {
    public String pic() {
        StringBuilder square = new StringBuilder();
        for (int i = 0; i <5 ; i++) {
            square.append("******");
        }
        return square.toString();
    }
}
