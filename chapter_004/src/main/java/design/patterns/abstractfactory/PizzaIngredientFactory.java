package design.patterns.abstractfactory;

public interface PizzaIngredientFactory {
    Dough createDough();
    Sause createSause();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClams();
}
