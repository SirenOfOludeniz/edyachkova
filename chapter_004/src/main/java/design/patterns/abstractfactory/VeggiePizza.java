package design.patterns.abstractfactory;

public class VeggiePizza extends Pizza{
    PizzaIngredientFactory ingredientFactory;

    public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sause = ingredientFactory.createSause();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
    }
}
