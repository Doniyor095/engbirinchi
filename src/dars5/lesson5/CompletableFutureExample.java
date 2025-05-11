package uz.pdp.lesson5;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        completableFuture();
    }

    static void future() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> submit = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "Hello world!!";
            }
        });

        System.out.println("submit.get() = " + submit.get());

        System.out.println("Main thread finished!!");
    }

    static void completableFuture() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread());
                return "Hello world!!";
            }
        }, executorService);

        stringCompletableFuture.thenAccept(
                System.out::println
        );


        System.out.println("Main thread finished!! => " + Thread.currentThread());

        Thread.sleep(2000);
    }


}
