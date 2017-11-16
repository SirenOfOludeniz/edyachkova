package ru.job4j.patternstrategy;

public class Paint {

    private Shape shape;

    public Paint(Shape shape) {
        this.shape = shape;
    }




    public void draw(Shape shape) {
        System.setOut(shape.pic());
    }
}
