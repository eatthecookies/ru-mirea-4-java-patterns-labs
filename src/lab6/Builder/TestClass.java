package lab6.Builder;

public class TestClass {
    public static void main(String[] args) {
        Pizza pizza = new PizzaBuilder()
                .setDough("thin crust")
                .setSauce("tomato")
                .setTopping("cheese, pepperoni, mushrooms")
                .build();

        System.out.println(pizza);
    }

}
