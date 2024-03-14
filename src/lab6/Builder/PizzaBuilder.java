package lab6.Builder;

public class PizzaBuilder {
    private String dough;
    private String sauce;
    private String topping;

    public PizzaBuilder setDough(String dough) {
        this.dough = dough;
        return this;
    }

    public PizzaBuilder setSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    public PizzaBuilder setTopping(String topping) {
        this.topping = topping;
        return this;
    }

    public Pizza build() {
        return new Pizza(dough, sauce, topping);
    }
}
