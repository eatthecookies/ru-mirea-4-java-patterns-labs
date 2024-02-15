package lab2;

import java.util.Comparator;

public class HumanAgeComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        // сортировка по возрастанию
        return o1.age - o2.age;
    }
}
