package dars2.git_hub;

public class Main {
    public static void main(String[] args) {
        Counter2 counter = new Counter2();

        Thread t1 = new Thread();
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }

        Thread t2 = new Thread();
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }


        System.out.println("Final count: " + counter.getCount());
    }
}
