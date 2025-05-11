package dars1;

public class FileDowlander {
    public static void main(String[] args) {

        Thread f1 = new Thread(new FileDownloader("File - 1"));
        Thread f2 = new Thread(new FileDownloader("File - 2"));
        Thread f3 = new Thread(new FileDownloader("File - 3"));
        Thread f4 = new Thread(new FileDownloader("File - 4"));


        f1.start();
        f2.start();
        f3.start();
        f4.start();

        try {
            f1.join();
            f2.join();
            f3.join();
            f4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
class FileDownloader implements Runnable{
    private String fileName;

    FileDownloader(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        System.out.println(fileName + " Yuklanmoqda!!");

        int time = (int)(Math.random() * 4000 + 1000);

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File yuklandi!!!  " + fileName);

    }
}
