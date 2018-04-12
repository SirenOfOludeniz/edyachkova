package design.patterns.factorymethod;

public class CaliforniaStylePizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String item) {
        Pizza pizza = null;
        if (item.equals("cheese")) {
            pizza = new CaliforniaCheesePizza();
        }
        if (item.equals("pepperoni")) {
            pizza = new CaliforniaPepperoniPizza();
        }
        if (item.equals("clam")) {
            pizza = new CaliforniaClamPizza();
        }
        if (item.equals("veggie")) {
            pizza = new CaliforniaVeggiePizza();
        }
        return pizza;
    }
}
