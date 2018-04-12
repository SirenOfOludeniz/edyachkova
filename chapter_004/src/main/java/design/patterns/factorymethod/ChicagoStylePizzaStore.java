package design.patterns.factorymethod;

public class ChicagoStylePizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String item) {
        Pizza pizza = null;
        if (item.equals("cheese")) {
            pizza = new ChicagoCheesePizza();
        }
        if (item.equals("pepperoni")) {
            pizza = new ChicagoPepperoniPizza();
        }
        if (item.equals("clam")) {
            pizza = new ChicagoClamPizza();
        }
        if (item.equals("veggie")) {
            pizza = new ChicagoVeggiPizza();
        }
        return pizza;
    }
}
