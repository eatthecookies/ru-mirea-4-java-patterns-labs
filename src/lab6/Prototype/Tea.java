package lab6.Prototype;

public class Tea extends Drink{
    @Override
    void brew() {
        System.out.println("Завариваю чай...");
    }

    @Override
    void addCondiments() {
        System.out.println("Добавляю лемон...");
    }
}
