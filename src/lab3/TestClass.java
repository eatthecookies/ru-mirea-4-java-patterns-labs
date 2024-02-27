package lab3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestClass {
    public static void main(String[] args) throws InterruptedException {

        // Пробуем обойтись без потокобезопасного интерфейса
        HashMap<String, Integer> map = new HashMap<>();
        // Запускаем потоки
        Thread one = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                map.put("Key" + i, i);
            }
        });
        Thread two = new Thread(()->{
            for (int i = 1000; i < 2000; i++) {
                map.put("Key" + i, i);
            }
        });

        one.start();
        two.start();
        // Ждем пока они завершаться
        one.join();
        two.join();
        // Получаем неверный и нестабильный результат
        System.out.println("Размер Map: " + map.size());


        // С использование потокобезопасного интерфейса
        LockedMap<String, Integer> safeMap = new LockedMap<>();

        Thread safeOne = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                safeMap.put("Key" + i, i);
            }
        });
        Thread safeTwo = new Thread(()->{
            for (int i = 1000; i < 2000; i++) {
                safeMap.put("Key" + i, i);
            }
        });

        safeOne.start();
        safeTwo.start();

        safeOne.join();
        safeTwo.join();

        System.out.println("Размер Map: " + safeMap.size());

        // Тестирование SynchronizedSet
        Set<Integer> set = new HashSet<>();
        // Запускаем потоки
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                set.add(i);
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 10000; i < 20000; i++) {
                set.add(i);
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Размер Set: " + set.size());

        SynchronizedSet<Integer> safeSet = new SynchronizedSet<>();
        // Запускаем потоки
        Thread thread12 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                safeSet.add(i);
            }
        });
        Thread thread22 = new Thread(()->{
            for (int i = 10000; i < 20000; i++) {
                safeSet.add(i);
            }
        });
        thread12.start();
        thread22.start();

        thread12.join();
        thread22.join();

        System.out.println("Размер Set: " + safeSet.size());
    }

}
