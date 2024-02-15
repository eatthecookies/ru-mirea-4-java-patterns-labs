package lab2;

import java.util.Comparator;

public class WeightReverseComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        // сортировка по убыванию
        return o2.weight - o1.weight;
    }
}
