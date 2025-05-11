package uyishi4.github;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TaskExecutor {

    private final ExecutorService executor;

    public TaskExecutor(ExecutorService executor) {
        this.executor = executor;
    }

    public void executeTask(Runnable task) {
        executor.execute(task);
    }

    public <T> Future<T> submitTask(Callable<T> task) {
        return executor.submit(task);
    }


    public void shutdown() {
        executor.shutdown();
    }
}
