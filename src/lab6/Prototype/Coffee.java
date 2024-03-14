package lab6.Prototype;

public class Coffee extends Drink{
    @Override
    void brew() {
        System.out.println("Приготавливаю кофе");
    }

    @Override
    void addCondiments() {
        System.out.println("Добавляю сахарку..");
    }
}
