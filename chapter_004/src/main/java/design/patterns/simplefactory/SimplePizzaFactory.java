package design.patterns.simplefactory;

import design.patterns.factorymethod.*;

public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        }
        if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        }
        if (type.equals("clam")) {
            pizza = new ClamPizza();
        }
        if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}
