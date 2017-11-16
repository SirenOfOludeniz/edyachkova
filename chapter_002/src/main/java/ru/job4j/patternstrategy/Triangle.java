package ru.job4j.patternstrategy;

public class Triangle implements Shape {
    public String pic() {
        StringBuilder triangle = new StringBuilder();

            triangle.append("*");
            triangle.append("**");
            triangle.append("***");
            triangle.append("****");
            triangle.append("*****");


        return triangle.toString();
    }
}
