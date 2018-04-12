package design.patterns.abstractfactory;

public class TestDrive {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        nyPizzaStore.orderPizza("cheese");



//        NYPizzaIngredientFactory factory = new NYPizzaIngredientFactory();
//        CheesePizza cheesePizza = new CheesePizza(factory);
    }
}
