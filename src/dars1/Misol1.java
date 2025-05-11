package dars1;

class MyRunnable implements Runnable {
    private String threadName;

    MyRunnable(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println(threadName + " ishlayapti...");
    }
}

public class Misol1 {
    public static void main(String[] args) {
        // 4 ta Runnable obyekt
        Thread t1 = new Thread(new MyRunnable("Thread-1"));
        Thread t2 = new Thread(new MyRunnable("Thread-2"));
        Thread t3 = new Thread(new MyRunnable("Thread-3"));
        Thread t4 = new Thread(new MyRunnable("Thread-4"));
        Thread t5 = new Thread(new MyRunnable("Thread-5"));

        // Threadlarni ishga tushirish
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
