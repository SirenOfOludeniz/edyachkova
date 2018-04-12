package design.patterns.factorymethod;

public class NYCheesePizza extends Pizza {

    public NYCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sause = "Marinara Sause";

        toppings.add("Grated Reggiano Cheese");
    }

}
