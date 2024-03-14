package lab6.FabricMethod;

class ConcreteProductBFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}