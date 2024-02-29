package lab5;

public enum SingletonPattern2 {
    INSTANCE;

    public static SingletonPattern2 getInstance() {
        return INSTANCE;
    }
}
