package ru.job4j.patternstrategy;

public class Triangle implements Shape {
    public String pic() {
        StringBuilder triangle = new StringBuilder();


        for (int j = 5; j > 0; j--) {
            for (int i = j - 1; i < 5; i++) {
                triangle.append("*");
            }
            triangle.append(System.lineSeparator());

        }


        return triangle.toString();
    }
}
