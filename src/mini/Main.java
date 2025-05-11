package mini;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int initialAccounts = 10;
        int initialBalance = 1000;
        Random random = new Random();
        Bank bank = new Bank(initialAccounts, initialBalance);


        Runnable runnable = new Runnable() {
            public synchronized void run() {
                while (true) {
                    int from = random.nextInt(0, initialAccounts);
                    int to = random.nextInt(0, initialAccounts);
                    if (from == to) {
                        continue;
                    }

                    int amount = random.nextInt(0, initialBalance);
                    bank.transfer(from, to, amount);
                }
            }
        };


        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();


    }
}
