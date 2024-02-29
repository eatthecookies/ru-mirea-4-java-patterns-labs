package lab4;
import javax.swing.tree.FixedHeightLayoutCache;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class MyExecutorService implements ExecutorService {
    private final ExecutorService es;
    public MyExecutorService(int n) {
        es = Executors.newFixedThreadPool(n);
    }

    @Override
    public void shutdown() {
        es.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return es.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return es.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return es.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return es.awaitTermination(timeout, unit);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return es.submit(task);
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return es.submit(task, result);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return es.submit(task);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return es.invokeAll(tasks);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return es.invokeAll(tasks, timeout, unit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return es.invokeAny(tasks);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return es.invokeAny(tasks, timeout, unit);
    }

    @Override
    public void close() {
        es.close();
    }

    @Override
    public void execute(Runnable command) {
        es.execute(command);
    }
}
