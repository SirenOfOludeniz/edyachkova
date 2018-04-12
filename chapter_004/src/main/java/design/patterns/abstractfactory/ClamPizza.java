package design.patterns.abstractfactory;

public class ClamPizza extends Pizza{
    PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sause = ingredientFactory.createSause();
        cheese = ingredientFactory.createCheese();
        clams = ingredientFactory.createClams();
    }
}
