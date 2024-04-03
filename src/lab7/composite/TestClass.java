package lab7.composite;

public class TestClass {
    public static void main(String[] args) {
        Leaf triangle = new Leaf();
        triangle.setName("triangle");
        Leaf circle = new Leaf();
        circle.setName("circle");
        Leaf square = new Leaf();
        square.setName("square");

        Composite shapePackage = new Composite();
        shapePackage.add(triangle);
        shapePackage.add(circle);

        square.draw();
        shapePackage.draw();
    }
}
