package dars2.uyIshi.masala_2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MessageBoard messageBoard = new MessageBoard();

        WriterThread writerThread = new WriterThread(messageBoard);

        ReaderThread readerThread1 = new ReaderThread(messageBoard);
        ReaderThread readerThread2 = new ReaderThread(messageBoard);
        ReaderThread readerThread3 = new ReaderThread(messageBoard);

        writerThread.start();
        readerThread1.start();
        readerThread2.start();
        readerThread3.start();

        Thread.sleep(10000);
        messageBoard.setActive(false);

        System.out.println("Dastur to‘xtatilmoqda.");
    }
}
