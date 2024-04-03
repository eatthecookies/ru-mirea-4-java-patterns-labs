package lab7.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Shape{
    List<Shape> list = new ArrayList<>();
    @Override
    public void draw() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).draw();
        }
    }


    public void add(Shape c) {
        list.add(c);
    }

    public void remove(Shape c) {
        list.remove(c);
    }

    public Shape getChild(int i) {
        return list.get(i);
    }
}
