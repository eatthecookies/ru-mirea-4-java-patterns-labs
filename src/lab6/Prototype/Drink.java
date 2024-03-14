package lab6.Prototype;

abstract class Drink {
    final public void createDrink(){
        boilwater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();
    abstract void addCondiments();

    public  void boilwater(){
        System.out.println("Набираю воду...");
    }
    public  void pourInCup(){
        System.out.println("Наливаю в емкость...");
    }
}
