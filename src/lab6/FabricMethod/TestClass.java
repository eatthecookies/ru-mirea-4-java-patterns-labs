package lab6.FabricMethod;

public class TestClass {
    public static void main(String[] args) {
        ProductFactory factoryA = new ConcreteProductAFactory();
        Product productA = factoryA.createProduct();
        productA.doSomething();

        ProductFactory factoryB = new ConcreteProductBFactory();
        Product productB = factoryB.createProduct();
        productB.doSomething();
    }
}
