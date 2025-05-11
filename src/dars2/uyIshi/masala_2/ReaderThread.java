package dars2.uyIshi.masala_2;

public class ReaderThread extends Thread {
    private final MessageBoard messageBoard;

    public ReaderThread(MessageBoard messageBoard) {
        this.messageBoard = messageBoard;
    }

    @Override
    public void run() {
        while (messageBoard.isActive()) {
//            String message = messageBoard.readMessage();
//            System.out.println(Thread.currentThread().getName() + " o'qidi: " + message);

        }
    }
}
