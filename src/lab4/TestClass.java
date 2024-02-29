package lab4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestClass {
    public static void main(String[] args) {
        ExecutorService executor = new MyExecutorService(2);
        // если использовать более двух потоков, эта задача будет медленнее, потому что тут есть задержка
        executor.submit(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("We run it");
        });

        executor.submit(() -> System.out.println("Start"));

        executor.shutdown();
    }
}

