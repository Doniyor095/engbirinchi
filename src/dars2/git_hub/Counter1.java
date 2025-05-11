package dars2.git_hub;

public class Counter1 {
    private int count = 0;

    public void increment() {
        count++;
    }
    public synchronized void incrementsnx() {
        count++;
    }
    public void incrementWithBlock() {
        synchronized (this) {
            count++;
        }
    }
    public int getCount() {
        return count;
    }
}
