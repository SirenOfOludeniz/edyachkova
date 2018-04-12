package design.patterns.factorymethod;

import java.util.ArrayList;

public abstract class Pizza {
    String name;
    String dough;
    String sause;
    ArrayList<String> toppings = new ArrayList<>();

    void prepare() {
        System.out.println("Preparing " + name);
        for (String topping : toppings) {
            System.out.println(" " + topping);
        }
    }
    void bake() {
        System.out.println("Bake for 25 minutes at 350");

    }
    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");

    }
    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }
    public String getName() {
        return name;
    }
}
