package lab5;

public class TestClass {
    public static void main(String[] args) {
        SingletonPattern1 sp11 = SingletonPattern1.getInstance();
        SingletonPattern1 sp12 = SingletonPattern1.getInstance();
        System.out.println(sp11 == sp12);

        SingletonPattern2 sp21 = SingletonPattern2.getInstance();
        SingletonPattern2 sp22 = SingletonPattern2.getInstance();
        System.out.println(sp21 == sp22);

        SingletonPattern3 sp31 = SingletonPattern3.getInstance();
        SingletonPattern3 sp32 = SingletonPattern3.getInstance();
        System.out.println(sp31 == sp32);
    }
}
