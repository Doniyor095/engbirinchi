package organish1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ComFutFunctions1 {
    public static void main(String[] args) {
        String user = "John";
        registerUser(user);
    }

    private static void registerUser(String user) {
        try {
            // Har bir funksiyani parallel ishga tushiramiz
            CompletableFuture<Void> validation = CompletableFuture.runAsync(() -> {
                try {
                    validateAccount(user);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            CompletableFuture<Void> upload = CompletableFuture.runAsync(() -> {
                try {
                    uploadFiles(user);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            CompletableFuture<Void> sms = CompletableFuture.runAsync(() -> {
                try {
                    sendSms(user);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            CompletableFuture<Void> db = CompletableFuture.runAsync(() -> {
                try {
                    saveDb(user);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            // Hamma vazifalar tugashini kutamiz
            CompletableFuture.allOf(validation, upload, sms, db).join();

            System.out.println("Muvaffaqiyatli bajarildi!!!");
        } catch (Exception e) {
            System.out.println("Xatolik yuz berdi!!");
        }
    }

    private static void saveDb(String user) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.printf("DBga saqlandi [ %s ] :: %s%n", user, Thread.currentThread().getName());
    }

    private static void sendSms(String user) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.printf("SMS yuborildi [ %s ] :: %s%n", user, Thread.currentThread().getName());
    }

    private static void uploadFiles(String user) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.out.printf("Fayllar yuklandi [ %s ] :: %s%n", user, Thread.currentThread().getName());
    }

    private static void validateAccount(String user) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.printf("Foydalanuvchi tekshirildi [ %s ] :: %s%n", user, Thread.currentThread().getName());
    }
}

