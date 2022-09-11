public class ThreadNewExample extends Thread {

    public ThreadNewExample() {
        this.setPriority(MIN_PRIORITY);
    }

    @Override
    public void run() {
        System.out.println("Thread new started");
        for (int i = 0; i < 10; i++)
            System.out.println("Thread " + i);
        System.out.println("Thread new stopped");
    }
}
