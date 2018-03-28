package design.patterns.decorator;

public class Soy extends Beverage{
    Beverage beverage;
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
    @Override
    public double cost() {
        return .15 + beverage.cost();
    }
}
