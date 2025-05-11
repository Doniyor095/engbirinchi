package uyishi4.github;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        TaskExecutor taskExecutor = new TaskExecutor(Executors.newFixedThreadPool(2));

        Runnable runnableTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable task bajarildi. Thread: " + Thread.currentThread().getName());
            }
        };

        Callable<String> callableTask = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Callable task natijasi. Thread: " + Thread.currentThread().getName();
            }
        };

        taskExecutor.executeTask(runnableTask);

        Future<String> future = taskExecutor.submitTask(callableTask);
        try {
            String result = future.get();
            System.out.println("Callable dan olingan natija: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        taskExecutor.shutdown();
    }
}

