package design.patterns.abstractfactory;

public class CheesePizza extends Pizza{

    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sause = ingredientFactory.createSause();
        cheese = ingredientFactory.createCheese();
    }
}
