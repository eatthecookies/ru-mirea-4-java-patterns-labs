package lab6.AbstractFactory;

public class TestClass {
    public static void main(String[] args) {
        AbstractFactory factory = new Factory();

        ProductA productA = factory.createProductA();
        ProductB productB = factory.createProductB();

        productA.doSomething();
        productB.doSomethingElse();
    }
}
