package lab7.decorator;

public class TestClass {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();

        System.out.println();

        Shape decoratedCircle = new RedBorderDecorator(circle);
        decoratedCircle.draw();
    }
}
