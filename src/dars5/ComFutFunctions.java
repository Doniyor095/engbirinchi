package dars5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ComFutFunctions {
    public static void main(String[] args) {

        ExecutorService  executorService = Executors.newFixedThreadPool(15);

        String user = "John";
        registerUser(user);
       

    }

    private static void registerUser(String user) {
        try {
            // save user files to disk 5 s
            CompletableFuture<Void> uploadFuture = CompletableFuture.runAsync(() -> {
                try {
                    validateAccount(user);
                    uploadFiles(user);

                } catch (InterruptedException ignored) {}
            });


            // validate account 2 s


            // send sms to email 1
            sendSms(user);

            // save to db 1
            saveDb(user);

            System.out.println("Successfully!!!");

        } catch (Exception e) {
            System.out.println("Error occurred!!");
        }
    }


    private static void saveDb(String user) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.printf("Save to db user [ %s ] :: %s%n", user, Thread.currentThread().getName());
    }

    private static void sendSms(String user) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.printf("Send sms user [ %s ] :: %s%n", user, Thread.currentThread().getName());
    }

    private static String uploadFiles(String user) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.out.printf("Upload user [ %s ] files :: %s%n", user, Thread.currentThread().getName());
        return user;
    }

    private static void validateAccount(String user) throws InterruptedException {
//        Thread.sleep(2000);
        TimeUnit.SECONDS.sleep(2);
        System.out.printf("Validate user [ %s ] :: %s%n", user, Thread.currentThread().getName());
    }


}
