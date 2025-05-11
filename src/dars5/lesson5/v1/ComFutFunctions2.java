package dars5.lesson5.v1;

import java.util.concurrent.TimeUnit;

public class ComFutFunctions2 {
    public static void main(String[] args) throws InterruptedException {

        long nano = System.currentTimeMillis();
        String user1 = "John";
        String user2 = "Tom";
        String user3 = "Jerry";
        Thread th1 = registerUser(user1); // 9s
        Thread th2 = registerUser(user2);
        Thread th3 = registerUser(user3);

        th1.start();
        th2.start();
        th3.start();

        th1.join();
        th2.join();
        th3.join();

        System.out.println(System.currentTimeMillis() - nano);

    }

    private static Thread registerUser(String user) throws InterruptedException {
        return new Thread(() -> {
            try {
                // validate account 2 s
                validateAccount(user);

                // save user files to disk 5 s
                uploadFiles(user);

                // send sms to email 1
                sendSms(user);

                // save to db 1
                saveDb(user);

                System.out.println("Successfully!!!");

            } catch (Exception e) {
                System.out.println("Error occurred!!");
            }


        });
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
