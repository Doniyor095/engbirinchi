package organish1;

import java.util.concurrent.TimeUnit;

public class ComFutFunctions {
    public static void main(String[] args) {

        String user = "John";
        registerUser(user);

    }

    private static void registerUser(String user) {
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
