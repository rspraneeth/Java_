public class RunnableThreadExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread runnable started");
        for (int i = 0; i<10; i++)
            System.out.println("Thread Runnable "+i);
    }

}
