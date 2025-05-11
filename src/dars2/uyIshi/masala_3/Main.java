package dars2.uyIshi.masala_3;

public class Main {
    public static void main(String[] args) {
        Resource qalam = new Resource("Qalam");
        Resource qogoz = new Resource("Qog'oz");

        // Player1: Qalam -> Qog'oz
        PlayerThread player1 = new PlayerThread(qalam, qogoz);

        // Player2: Qog'oz -> Qalam (Deadlock bo'lishi uchun)
        PlayerThread player2 = new PlayerThread(qogoz, qalam);

        player1.setName("Player 1");
        player2.setName("Player 2");

        player1.start();
        player2.start();
    }
}
