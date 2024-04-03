package lab7.decorator;

public class RedBorderDecorator implements Shape{
    Shape shape;

    public RedBorderDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
        drawRedBorder();
    }
    private void drawRedBorder() {
        System.out.print("Adding red border");
    }
}
