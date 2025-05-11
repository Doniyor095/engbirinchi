package mini;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private Integer[] accounts;

    public Bank(int initialAccounts, int initialBalance) {
        accounts = new Integer[initialAccounts];

        Arrays.fill(accounts, initialBalance);
//        for (int i = 0; i < accounts.length; i++) {
//            accounts[i] = initialBalance;
//        }
    }

    public void transfer(int fromIndex, int toIndex, int amount) {
        Lock lock = new ReentrantLock();
        lock.lock();
        if (accounts[fromIndex] < amount) {
            return;
        }
        accounts[fromIndex] -= amount;
        accounts[toIndex] += amount;

        System.out.printf("%s transfer from %d to %d. Bank balance: %s ::: %s\n", amount, fromIndex, toIndex, balance(), Thread.currentThread().getName());

    }

    private Integer balance() {
        int sum = 0;
        for (int i = 0; i < accounts.length; i++) {
            sum += accounts[i];
        }
        return sum;
    }

}



