package concurency.lesson10;

public class SingletonFactory {
    private static Service service;

    public static Service getInstance() {
        if (service == null) {
            synchronized (SingletonFactory.class) {
                if (service == null) {
                    service = new Service();
                }
            }
        }
        return service;
    }
}


class Service {

    void m1() {

    }
}

class Test {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(SingletonFactory.getInstance().hashCode());
                }
            }).start();
        }
    }
}