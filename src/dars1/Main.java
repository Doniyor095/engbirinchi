package dars1;

public class Main {
    public static void main(String[] args) {
        int n = 10; // Number of threads
        for (int i = 0; i < n; i++) {
            Thread objec = new Thread(new Multithreading());
            objec.start();
//            Multithreading objec = new Multithreading();
//            objec.start();
        }
    }
}

//class Multithreading extends Thread {
//    public void run()
//    {
//        try {
//            // Displaying the thread that is running
//            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
//        }
//        catch (Exception e) {
//
//            // Throwing an exception
//            System.out.println("Exception is caught");
//        }
//    }
//}
class Multithreading implements Runnable {
    public void run()
    {
        try {
            // Displaying the thread that is running
            System.out.println(
                    "Thread " + Thread.currentThread().getId()
                            + " is running");
        }
        catch (Exception e) {

            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}
