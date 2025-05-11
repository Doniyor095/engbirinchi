package dars2.uyIshi.masala_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
    String name;
    Lock lock = new ReentrantLock();

    public Resource(String name) {
        this.name = name;
    }
}

