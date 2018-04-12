package design.patterns.abstractfactory;

import java.util.ArrayList;

public abstract class Pizza {

    String name;
    Dough dough;
    Sause sause;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;
    ArrayList<String> toppings = new ArrayList<>();

    abstract void prepare();


    void bake() {
        System.out.println("Bake for 25 minutes at 350");

    }
    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");

    }
    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String toString() {
        return "";
    }

}
