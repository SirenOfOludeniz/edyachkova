package design.patterns.factorymethod;

public class NYStylePizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String item) {
        Pizza pizza = null;
        if (item.equals("cheese")) {
            pizza = new NYCheesePizza();
        }
        if (item.equals("pepperoni")) {
            pizza = new NYPepperoniPizza();
        }
        if (item.equals("clam")) {
            pizza = new NYClamPizza();
        }
        if (item.equals("veggie")) {
            pizza = new NYVeggiePizza();
        }
        return pizza;
    }
}
