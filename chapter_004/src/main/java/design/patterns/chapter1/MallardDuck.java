package design.patterns.chapter1;

public class MallardDuck extends Duck{

    public MallardDuck() {
        quackBehavior = new Qyack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I`m a real mallard duck!");
    }
}
