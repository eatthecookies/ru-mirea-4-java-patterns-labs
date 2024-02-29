package lab5;

public class SingletonPattern3 {
    private static final SingletonPattern3 instance = new SingletonPattern3();

    private SingletonPattern3() {
        // private конструктор, чтобы предотвратить создание экземпляров извне
    }

    public static SingletonPattern3 getInstance() {
        return instance;
    }
}
