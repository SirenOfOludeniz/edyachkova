package design.patterns.factorymethod;

public class ChicagoCheesePizza extends Pizza {

    public ChicagoCheesePizza() {
        name = " Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sause = "Plum Tomato Sauce";

        toppings.add("Chredded Mozzarella Cheese");
    }

    @Override
    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
