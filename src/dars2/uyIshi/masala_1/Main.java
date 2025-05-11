package dars2.uyIshi.masala_1;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TicketCounter ticketCounter = new TicketCounter();

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                sellTicketsRandomly(ticketCounter);
            }
        };
        Thread t1 = new Thread(task1, "Thread-1");

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                sellTicketsRandomly(ticketCounter);
            }
        };
        Thread t2 = new Thread(task2, "Thread-2");

        Runnable task3 = new Runnable() {
            @Override
            public void run() {
                sellTicketsRandomly(ticketCounter);
            }
        };
        Thread t3 = new Thread(task3, "Thread-3");

        Runnable task4 = new Runnable() {
            @Override
            public void run() {
                sellTicketsRandomly(ticketCounter);
            }
        };
        Thread t4 = new Thread(task4, "Thread-4");

        Runnable task5 = new Runnable() {
            @Override
            public void run() {
                sellTicketsRandomly(ticketCounter);
            }
        };
        Thread t5 = new Thread(task5, "Thread-5");


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();



        System.out.println("\nNatija:");
        System.out.println("Qolgan chiptalar: " + ticketCounter.getAvailableTickets());
    }

    private static void sellTicketsRandomly(TicketCounter ticketCounter) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int ticketsToSell = random.nextInt(10) + 1;
            ticketCounter.sellTickets(ticketsToSell);

        }
    }
}
