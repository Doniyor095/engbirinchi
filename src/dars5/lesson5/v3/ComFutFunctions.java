package dars5.lesson5.v3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;

public class ComFutFunctions {
    public static void main(String[] args) throws InterruptedException {

        long nano = System.currentTimeMillis();
        String user1 = "John";
        String user2 = "Tom";
        String user3 = "Jerry";


        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(registerUser(user1), registerUser(user2), registerUser(user3));

        CompletableFuture<Void> result = voidCompletableFuture.thenAccept(_ -> System.out.println(System.currentTimeMillis() - nano));

        result.join();


    }

    private static CompletableFuture registerUser(String user) throws InterruptedException {

        // main => worker-1

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(new Runnable() {
            // worker- 1
            @Override
            public void run() {
                try {
                    validateAccount(user);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).thenRunAsync(new Runnable() {
            //worker - 2

            @Override
            public void run() {


                CompletableFuture<Void> uploadFilesFuture = CompletableFuture.runAsync(new Runnable() {
                    //worker-2 => worker-3
                    @Override
                    public void run() {
                        try {
                            uploadFiles(user);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });

                CompletableFuture<Void> sendSmsFuture = CompletableFuture.runAsync(new Runnable() {
                    //worker-2 => worker-4
                    @Override
                    public void run() {
                        try {
                            sendSms(user);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });

                CompletableFuture<Void> saveDbFuture = CompletableFuture.runAsync(new Runnable() {
                    //worker-2 => worker-5
                    @Override
                    public void run() {

                        try {
                            saveDb(user);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                CompletableFuture<Void> result = CompletableFuture.allOf(saveDbFuture, uploadFilesFuture, sendSmsFuture);

                // worker-2 wait
                result.join();
            }


        }).exceptionally(new Function<Throwable, Void>() {
            // worker - 2
            @Override
            public Void apply(Throwable throwable) {
                System.out.println("Error occurred!!");
                return null;
            }
        }).thenAccept(new Consumer<Void>() {
            // worker - 2
            @Override
            public void accept(Void unused) {
                System.out.println("Successfully");
            }
        });


        return voidCompletableFuture;


    }

    private static void saveDb(String user) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.printf("Save to db user [ %s ] :: %s%n", user, Thread.currentThread().getName());
    }

    private static void sendSms(String user) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.printf("Send sms user [ %s ] :: %s%n", user, Thread.currentThread().getName());
    }

    private static void uploadFiles(String user) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.out.printf("Upload user [ %s ] files :: %s%n", user, Thread.currentThread().getName());
    }

    private static void validateAccount(String user) throws InterruptedException {
//        Thread.sleep(2000);
        TimeUnit.SECONDS.sleep(2);
        System.out.printf("Validate user [ %s ] :: %s%n", user, Thread.currentThread().getName());
    }
}
