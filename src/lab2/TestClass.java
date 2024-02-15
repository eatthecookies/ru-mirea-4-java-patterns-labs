package lab2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

public class TestClass {
    public static void main(String[] args) {
        ArrayList<Human> listOfHumans = new ArrayList<>();

        // добавление в список новых людей
        listOfHumans.add(new Human(10, "Александр", "Воробьев",
                LocalDate.of(2004, 4, 3), 75));
        listOfHumans.add(new Human(30, "Иван", "Иванов",
                LocalDate.of(1999, 4, 3), 105));
        listOfHumans.add(new Human(2, "Иван", "Чай",
                LocalDate.of(2000, 4, 3), 55));


        System.out.println("Сортировка по убыванию веса:");
        listOfHumans.stream().sorted(new WeightReverseComparator()).forEach(System.out::println);

        System.out.println("\nФильтрация по фамилии Не Иванов:");
        listOfHumans.stream().filter( human -> !Objects.equals(human.lastName, "Иванов")).forEach(System.out::println);

        System.out.println("\nСортировка по возрасту:");
        listOfHumans.stream().sorted(new HumanAgeComparator()).forEach(System.out::println);

        System.out.println("\nПроизведение всех возрастов:");
        int result = listOfHumans.stream().mapToInt(Human::getAge).reduce( 1,(a, b) -> a * b);
        System.out.println(result);
    }
}
