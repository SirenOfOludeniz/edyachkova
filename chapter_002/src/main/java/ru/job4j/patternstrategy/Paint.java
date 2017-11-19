package ru.job4j.patternstrategy;


public class Paint {

    private Shape shape;

    public Paint(Shape shape) {
        this.shape = shape;
    }

    public Paint() { }

    public void draw(Shape shape) {
        System.out.println(shape.pic());
    }

    public static void main(String[] args) {
        Paint paint = new Paint(new Triangle());
        paint.draw(new Triangle());

        System.out.println("");

        Paint paint1 = new Paint(new Square());
        paint1.draw(new Square());
    }
}
