package dars2.uyIshi.masala_2;

public class WriterThread extends Thread {
    private final MessageBoard messageBoard;
    private int counter = 1;

    public WriterThread(MessageBoard messageBoard) {
        this.messageBoard = messageBoard;
    }

    @Override
    public void run() {
        while (messageBoard.isActive()) {
//            messageBoard.writeMessage("Xabar " + counter);
//            System.out.println("Yozilgan xabar: " + counter);
//            counter++;

        }
    }
}
