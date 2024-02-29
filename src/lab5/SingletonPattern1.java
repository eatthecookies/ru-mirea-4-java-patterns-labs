package lab5;

public class SingletonPattern1 {
    private static SingletonPattern1 instance;
    public static synchronized SingletonPattern1 getInstance() {
        if(instance == null) {
            instance = new SingletonPattern1();
            return instance;
        }
        return instance;
    }
}
