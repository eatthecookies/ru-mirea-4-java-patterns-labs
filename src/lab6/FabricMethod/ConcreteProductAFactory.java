package lab6.FabricMethod;

class ConcreteProductAFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}