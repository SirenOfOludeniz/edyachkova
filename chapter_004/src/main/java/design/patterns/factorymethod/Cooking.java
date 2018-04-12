package design.patterns.factorymethod;

public class Cooking {
    public static void main(String[] args) {
        ChicagoStylePizzaStore ch = new ChicagoStylePizzaStore();
        ch.orderPizza("cheese");
    }
}
