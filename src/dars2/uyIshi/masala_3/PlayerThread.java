package dars2.uyIshi.masala_3;

public class PlayerThread extends Thread {
    private final Resource firstResource;
    private final Resource secondResource;

    public PlayerThread(Resource firstResource, Resource secondResource) {
        this.firstResource = firstResource;
        this.secondResource = secondResource;
    }

    @Override
    public void run() {
        firstResource.lock.lock();
        System.out.println(getName() + " " + firstResource.name + " resursini oldi.");
        secondResource.lock.lock();
        System.out.println(getName() + " " + secondResource.name + " resursini oldi.");
        System.out.println(getName() + " : Rasm chizildi!");

        firstResource.lock.unlock();
        secondResource.lock.unlock();

    }

}
