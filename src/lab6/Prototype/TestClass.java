package lab6.Prototype;

public class TestClass {
    public static void main(String[] args) {
        Drink coffee = new Coffee();
        coffee.createDrink();

        System.out.println();

        Drink tea = new Tea();
        tea.createDrink();
    }
}
