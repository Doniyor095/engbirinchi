package dars2.uyIshi.masala_1;

public class TicketCounter {
    private int availableTickets = 100;

   public synchronized void sellTickets(int count) {
        if (availableTickets >= count) {
            availableTickets -= count;
            System.out.println(Thread.currentThread().getName() + " chiptalarni sotdi " + count + " Qolgan chiptalar: " + availableTickets);
        } else {
            System.out.println(Thread.currentThread().getName() + ": Yetarli chipta yo'q. (Qolgan: " + availableTickets + ")");
        }
    }

    public int getAvailableTickets() {
        return availableTickets;
    }
}
