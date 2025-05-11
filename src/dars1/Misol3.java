package dars1;

public class Misol3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable3("Thread-1"));
        Thread t2 = new Thread(new MyRunnable3("Thread-2"));

        t1.start();
        t2.start();
    }
}
class MyRunnable3 implements Runnable {
    private String threadName;

    MyRunnable3(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " - " + i);
            try {
                Thread.sleep(500); // 0.5 soniya kutadi
            } catch (InterruptedException e) {
                System.out.println(threadName + " to'xtatildi!");
            }
        }
    }
}
