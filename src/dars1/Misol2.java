package dars1;

public class Misol2 extends Thread {
    private String threadName;

    Misol2(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println(threadName + " ishlayapti...");
    }
}
