package lab7.composite;

public class Leaf implements Shape{
    String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Drawing..." + name);
    }

}
