package design.patterns.decorator;

public class Mocha extends Beverage{
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
