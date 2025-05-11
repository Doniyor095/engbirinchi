package dars1;

public class Main2 {
    public static void main(String[] args) {
        // 4 ta Thread obyekt
        Misol2 t1 = new Misol2("Thread-1");
        Misol2 t2 = new Misol2("Thread-2");
        Misol2 t3 = new Misol2("Thread-3");
        Misol2 t4 = new Misol2("Thread-4");
        Misol2 t5 = new Misol2("Thread-5");

        // Threadlarni ishga tushirish
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
