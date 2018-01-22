 package ru.job4j.condition;



public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double distance(Point left, Point right) {
        return Math.sqrt((Math.pow(b.getX() - a.getX(), 2)) + Math.pow((b.getY() - a.getY()), 2));
    }

    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }
    public double area() {
        double rsl = -1;
        double ab = this.distance(this.a, this.b);
        double ac = this.distance(this.a, this.c);
        double bc = this.distance(this.b, this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            // написать формулу для расчета площади треугольника.
            //rsl =Math.sqrt((period(ab, ac, bc))*(((period(ab, ac, bc) -ab))*((period(ab, ac, bc) -ac))*((period(ab, ac, bc) -bc))));//площадь Герона
            rsl = Math.sqrt((p) * (((p - ab)) * ((p - ac)) * ((p - bc))));
        }
        return rsl;
    }
    private boolean exist(double ab, double ac, double bc) {
        boolean a = true;
        if (ab + bc > ac && ac + ab > bc && bc + ac > ab) {
            a = true;
        }
        return a;
    }




}

























